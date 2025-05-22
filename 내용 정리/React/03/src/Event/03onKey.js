// keydown
function handleKeyDown(event) {
  console.log("key down!", event.keyCode);
}

function MyComponent1() {
  return <div>keydown : <input type="text" onKeyDown={handleKeyDown} /></div>;
}

//keyup
function handleKeyUp(event) {
  console.log("key up! ", event.keyCode);
}

function MyComponent2() {
  return <div>keyup : <input type="text" onKeyUp={handleKeyUp} /></div>;
}

//keypress
function handleKeyPress(event) {
  console.log("key pressed! key : ", event.key);
}

function MyComponent3() {
  return <input type="text" onKeyPress={handleKeyPress} />;
}

export default {
  MyComponent1,
  MyComponent2,
  MyComponent3,
};
