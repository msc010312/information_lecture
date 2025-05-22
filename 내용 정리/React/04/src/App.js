import Basic1 from "./condition/01Basic";
function App() {
  return (
    <div className="App">
      <Basic1.Component01 isAuth={true}/>
      <hr/>
      <Basic1.Component02 isAuth={true}/>
      <hr/>
      <Basic1.Component03 item={['a','b','c','d']}/>
    </div>
  );
}

export default App;
