import MyContext from "./MyContext";
import { useState, useEffect, useContext } from "react";
import Child2 from "./Child2";
// 하위 컴포넌트에서 상위컴포넌트로 전달 (props 사용)
const Parents = () => {
    const { globalState, setGlobalstate } = useContext(MyContext); // provider에서 관리하는 상태값
    const [name, setName] = useState('mike');
    const handelNameChange = (name) => {
        setName(name);
    }
    useEffect(() => {
        console.log("change name")
    })
    return (
        <div>
            <h1>parents2</h1>
            <div>
                <span>parents value : {name}</span>
            </div>
            <h2>전역변수 : {globalState}</h2>
            전역변수 변경 <button>변경하기</button>
            <Child2 name={name} handelNameChange={handelNameChange} />
        </div>
    );
}
export default Parents;