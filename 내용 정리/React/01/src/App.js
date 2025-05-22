import {Element1,Element2,Element3,Element4,Element5} from "./JSX/JSX_Basic";
import DEFAULT from "./JSX/JSX_Basic";
import CUSTOM from "./JSX/CustomComponant";
import {Component01,Component02,Component03} from "./JSX/JSX_Event";

function App() {
  const headerTitle = "HEADER-TITLE"
  return (
    <div className="App">
      {/* <div className="header" style={{fontSize:"24px",color:"blue",background:"orange"}}>
        {headerTitle}
        {Element1}
        <Element2/>
      </div>
      <div className="main">main</div>
      <div className='footer'>
        <Element3 auth={"ROLE_ADMIN"} name={"kevin"}/>
        <hr/>
        <Element4 auth={"ROLE_USER"} name={"smith"}/>
        <hr/>
        <Element5 list={["aaa","bbb","ccc"]}/>
        <hr/>
        <DEFAULT.DefaultComponent1/>
        <DEFAULT.DefaultComponent2/>
        <hr/>
        <CUSTOM/>
      </div> */}
      <Component01/>
      <Component02/>
      <Component03/>
    </div>
  );
}

export default App;
