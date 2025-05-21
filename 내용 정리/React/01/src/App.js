import {Element1,Element2,Element3,Element4} from "./JSX/JSX_Basic";

function App() {
  const headerTitle = "HEADER-TITLE"
  return (
    <div className="App">
      <div className="header" style={{fontSize:"24px",color:"blue",background:"orange"}}>
        {headerTitle}
        {Element1}
        <Element2/>
      </div>
      <div className="main">main</div>
      <div className='footer'>
        <Element3 auth={"ROLE_ADMIN"} name={"kevin"}/>
        <hr/>
        <Element4 auth={"ROLE_USER"} name={"smith"}/>
      </div>
    </div>
  );
}

export default App;
