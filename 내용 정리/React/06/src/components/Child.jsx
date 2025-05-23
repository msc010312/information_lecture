
import { useState, useContext } from "react";
import MyContext from "./MyContext";
// 상위 컴포넌트에서 하위컴포넌트로 전달 (props 사용)
const Child = (props) => {
    const { globalState, setGlobalstate } = useContext(MyContext); // provider에서 관리하는 상태값
    return (
        <div>
            <h1>child</h1>
            <h2>전역변수 : {globalState}</h2>
            전역변수 변경 <button>변경하기</button>
            <div>
                <span>parents to value : {props.name}</span>
            </div>
        </div>
    );
}
export default Child;