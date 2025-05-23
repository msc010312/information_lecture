import { useState,useContext } from "react";
import Child from "./Child";
import MyContext from "./MyContext";
// 상위 컴포넌트에서 하위컴포넌트로 전달 (props 사용)
const Parents = () => {
    const [name,setName] = useState('kevin');
    const {globalState,setGlobalstate} = useContext(MyContext); // provider에서 관리하는 상태값
    return (
        <div>
            <h1>parents</h1>
            <h2>전역변수 : {globalState}</h2>
            전역변수 변경 <button onClick={(e)=>{setGlobalstate('parent change')}}>변경하기</button>
            <Child name={name}/>
        </div>
    );
}
export default Parents;