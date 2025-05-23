import { useState, useContext } from "react";
import MyContext from "./MyContext";
// 상위 컴포넌트에서 하위컴포넌트로 전달 (props 사용)
const Child2 = ({name, handelNameChange}) => {
    return (
        <div>
            <h1>child2</h1>
            <div>
                <span>parents to value : {name}</span>
            </div>
            <input type="text" placeholder="changing name" onChange={(event)=>{handelNameChange(event.target.value)}}/>
        </div>
    );
}
export default Child2;