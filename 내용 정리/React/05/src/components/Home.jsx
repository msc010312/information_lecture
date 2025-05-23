import { Link } from "react-router-dom";

const Home = () => {
    return (
        <div>
            <nav>
                <ul>
                    <li><Link to="/">home</Link></li>
                    <li><Link to="/about?name=mike&age=35">about</Link></li>
                    <li><Link to="/contact/evan/55">contact</Link></li>
                </ul>
            </nav>
            <h1>home</h1>
            <p>welcome</p>
        </div>
    )
}
export default Home;