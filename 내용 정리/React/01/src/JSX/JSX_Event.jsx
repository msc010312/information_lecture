
// 01
function handleClick01() {
    console.log("click-1");
}

export function Component01() {
    return (
        <div>
            <button onClick={handleClick01}>click me</button>
        </div>
    );
}

//02
export function Component02() {
    function handleClick02() {
    console.log("click-2");
    }
    return (
        <div>
            <button onClick={handleClick02}>click me</button>
        </div>
    );
}

//03
export function Component03() {
    function handleKeyDown(event) {
    console.log("keyDown", event.target.value);
    }
    return (
        <div>
            <input type="text" onKeyDown={handleKeyDown}/>
        </div>
    );
}