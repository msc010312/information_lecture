import { useState } from "react";
function handleChange(event) {
    console.log('value changed! event Key : ',event);
   }
  
  const MyComponent = ()=> {
    const [username,setUsername] = useState('');
    const [password,setPassword] = useState('');
    const handleUsernameChange = (event) => {
      setUsername(event.target.value);
      console.log("username : ", event.target.value);
    }
    const handlePasswordChange = (event) => {
      setPassword(event.target.value);
      console.log("password : ", event.target.value);
    }
    const handleSubmit = (event) => {
      event.preventDefault();
      console.log("username : " , username , "password : ", password)
    }
    return (
      <form onSubmit={{handleSubmit}}>
        username : <input type="text" name="username" onChange={handleUsernameChange}/>
        password : <input type="password" name="password" onChange={handlePasswordChange} />
        <button type="submit">Submit</button>
      </form>
    );
  }
  export default{
    MyComponent,
}
    