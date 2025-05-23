import { BrowserRouter as Router,Routes,Route} from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";
function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home/>}></Route>
          <Route path="/about" element={<About/>}></Route>
          <Route path="/contact/:name:/age" element={<Contact/>}></Route>
        </Routes>
      </Router>

    </div>
  );
}

export default App;
