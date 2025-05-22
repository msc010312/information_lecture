import {useState,useEffect} from "react";

const MyComponent = () => {
    const [count,setCount] = useState(0);
    const handleClick = () => {
        setCount(count+1)
        // console.log("button click", count);
    }
    // 최초 1회 실행
    useEffect (()=>{
        console.log('init setting')
    },[count])
    // count state가 변경될때마다 실행
    useEffect (()=>{
        console.log('count state changed', count)
    },[count])

    return (
        <div>
            <h1>title</h1>
            <h2>sub title</h2>
            <hr/>
            <button onClick={handleClick}>button count : {count}</button>
        </div>
    )
}

export default MyComponent;