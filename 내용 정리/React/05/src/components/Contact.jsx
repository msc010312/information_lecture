import { Link,useNavigate,useParams } from "react-router-dom";

const Contact = () => {
    const navigate = useNavigate();
    const {name,age} = useParams();
    const handleHome = () => {
        console.log("home")
        navigate("/")
    }
    const handleAbout = () => {
        console.log("about")
        navigate("/about?name="+name+"&age="+age)
    }
    const handleContact = () => {
        console.log("contact")
        navigate("/contact")
    }
    return (
        <div>
            <nav>
                <ul>
                    <li><button onClick={handleHome}>home</button></li>
                    <li><button onClick={handleAbout}>about</button></li>
                    <li><button onClick={handleContact}>contact</button></li>
                </ul>
            </nav>
            <h1>contact</h1>
            <p>welcome</p>
            name : {name} , age : {age}
        </div>
    )
}
export default Contact;