import { Link, useLocation } from "react-router-dom";
const About = () => {
    const location = useLocation();
    const query = new URLSearchParams(location.search);
   return (
        <div>
            <nav>
                <ul>
                    <li><Link to="/">home</Link></li>
                    <li><Link to="/about">about</Link></li>
                    <li><Link to="/contact">contact</Link></li>
                </ul>
            </nav>
            <h1>about</h1>
            <p>welcome</p>
            param : {query.get("name")},{query.get("age")}
        </div>
    )
}
export default About;