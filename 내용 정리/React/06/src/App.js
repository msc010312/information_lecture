import Parents from "./components/Parents";
import Parents2 from "./components/Parents2"
import MyProvider from "./components/Provider";
// import {  } from "module";
function App() {
  return (
    <MyProvider>
      <div className="App">
        <Parents></Parents>
        <hr />
        <Parents2></Parents2>
      </div>
    </MyProvider>
  );
}

export default App;
