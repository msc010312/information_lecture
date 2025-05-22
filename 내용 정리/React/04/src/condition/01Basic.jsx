// 01 IF문
const Component01 = ({isAuth}) => {
    if(isAuth) {
        return <h1>인증 되었습니다</h1>
    } else {
        return <h1>인증 실패</h1>
    }
}

// 02 삼항연산자
const Component02 = ({isAuth}) => {
    return (
        <>
            {isAuth?
                    (
                    <>
                        <h1>인증완료</h1>
                        <h2>user1 계정로그인 - </h2>
                    </>
                    )
                    :
                    (<h1>인증실패</h1>)
            }
        </>
    )
}

// 03 and 연산자
const Component03 = ({item}) => {
    return (
        <div className="item">
            {item.length>0 && item.map((item,idx) =>{
                return (
                    <div>
                        <li key={idx}>{item}</li>
                    </div>
                )
            })}
        </div>
    );
}

export default {
    Component01,
    Component02,
    Component03
}