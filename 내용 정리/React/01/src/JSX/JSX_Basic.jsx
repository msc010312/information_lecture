// jsx 기본 요소 생성
export const Element1 = <h1>hello world 1</h1>

// function 예약어로 export
export function Element2() {
    return <h2>hello world 2</h2>
}

// 외부 인자 받기
export function Element3(props){
    if (props.auth === "ROLE_ADMIN") {
        return <h2>hello admin , name : {props.name}</h2>
    }
    if (props.auth === "ROLE_USER") {
        return <h2>name : {props.name}</h2>
    }
}

// 외부 인자 받기 (구조분해할당)
export function Element4({auth,name}){
    if (auth === "ROLE_ADMIN") {
        return <h2>hello admin , name : {name}</h2>
    }
    if (auth === "ROLE_USER") {
        return <h2>name : {name}</h2>
    }
}

// 반복문 처리
export const Element5 = (props) => {
    const list = props.list;
    return (
        <div className="items">
            {list.map((item,index)=>{
                console.log(item);
                return <div key={index}>{item}</div>
            })}
        </div>
    );
}

// 기본 컴포넌트 EXPORT
const DefaultComponent1 = () => {
    return <h1>component 1</h1>
}

const DefaultComponent2 = () => {
    return <h1>component 2</h1>
}

export default {
    DefaultComponent1,
    DefaultComponent2
}