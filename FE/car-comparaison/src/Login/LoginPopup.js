import React , { useState, useRef, useEffect } from 'react';
import './LoginPopup.css';
import "../global.css";

export default function LoginPopup({closePopup, setUser, setIsLogged}) {
 const [username, setUsername] = useState('');
 const [password, setPassword] = useState('');
 const [email, setEmail] = useState('');
 const [usernameError, setUsernameError] = useState('');
 const [passwordError, setPasswordError] = useState(''); 
 const [emailError, setEmailError] = useState(''); 
 const [connectionErrorMessage, setConnectionErrorMessage] = useState('');
 const [signIn, setSignIn] = useState(true);
 const checkboxRef = useRef(null);
 const passwordRef = useRef(null);
 const emailRef = useRef(null);

 useEffect(() => { 
        document.addEventListener('keydown', handleEscapeKey);
        // eslint-disable-next-line
    },[]);

 const handleEscapeKey = (event) => {
    if (event.key === 'Escape') {
        closePopup();
        document.removeEventListener('keydown', handleEscapeKey);
    }
}
 const handleUsername = (event) => {
    setUsername(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };

  const handleCheckbox = () => {
    const checkboxElement = checkboxRef.current;
    const passwordElement = passwordRef.current;
    if (checkboxElement.checked) {
        passwordElement.type = 'text';
    } else {
        passwordElement.type = 'password';
    }
  };

  function handleLogin() {
    if (!validateFormSignIn()){
        return;
    }
    const connectionRequest = {
        nomUtilisateur: username.trim(),
       motDePasse: password.trim()
    };

    let message;

    fetch('http://localhost:8080/api/utilisateur/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(connectionRequest)
        })
        .then(response => {
            message = response;
            if (response.ok) {
                return response.json();
                
            } else {
                return showErrConnection(message);
            }
        })
        .then(data => {
            if (data){
                    document.getElementById("connectionErr").style.display = "none";
                    setIsLogged(true)
                    setUser(username) 
                    closePopup();
            }
        })
        .catch(error => {
           setConnectionErrorMessage("Internal server error. Please try again later.");
           document.getElementById("connectionErr").style.display = "inline";
        });
    }

    function handleSignUp(){
       if (validateEmail() && validatePassword() && validateUserName()){
        let requestData = {
            nomUtilisateur : username,
            motDePasse : password,
            email : email
        }
        fetch('http://localhost:8080/api/utilisateur/signUp', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestData)
        })
        .then(response => {
            if (response.ok) {
                document.getElementById("connectionErr").style.display = "none";
                    setIsLogged(true)
                    setUser(username) 
                    closePopup();
            } 
            if (response.status === 401) {
                setConnectionErrorMessage("Username or Email are already in use.");
                document.getElementById("connectionErr").style.display = "inline";
            }
        })
        .then(data => {
            console.log(data)
        })
        .catch(error => {
           setConnectionErrorMessage("Internal server error. Please try again later.");
           document.getElementById("connectionErr").style.display = "inline";
        });
    }
    }

    function validateUserName(){
        if (username.trim === ''){
            setUsernameError('*Please enter the username');
            document.getElementById("usernameErr").style.display = "inline";
            return false;
        }
        if (username.trim().length < 5 || username.trim().length > 20) {
            setUsernameError('*Username length must be between 5 and 20 characters.');
            document.getElementById("usernameErr").style.display = "inline";
            return false;
        } else {
            setUsernameError('');
            document.getElementById("usernameErr").style.display = "none";
        }
        return true;
    }

    function showErrConnection(code) {
        let errElement = document.getElementById("connectionErr");
        if (code.status === 404){
             setConnectionErrorMessage("Username or Password are incorrect.");
        } else {
             setConnectionErrorMessage("Connection Error, please try again.");
        }
        errElement.style.display = "inline";
    }

    function validateFormSignIn() {
        let isValid = true;
        if (username.trim().length < 5 || username.trim().length > 20) {
            setUsernameError('*Username length must be between 5 and 20 characters.');
            document.getElementById("usernameErr").style.display = "inline";
            isValid = false;
        } else {
            setUsernameError('');
            document.getElementById("usernameErr").style.display = "none";
        }
        if (!password.trim()) {
            setPasswordError('*Please enter the password');
            document.getElementById("passwordErr").style.display = "inline";
            isValid = false;
        } else if (password.trim().length < 8) {
            setPasswordError('*Password must be at least 8 characters long.');
            document.getElementById("passwordErr").style.display = "inline";
            isValid = false;
        } else {
            setPasswordError('');
            document.getElementById("passwordErr").style.display = "none";
        }
        
        return isValid;
    }

    function validateEmail(){
        const regex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;

        if (email.trim()==='') {
            setEmailError('Please enter email adress.');
            document.getElementById("emailErr").style.display = "inline";
            return false;
        } 
         if (!regex.test(email)) {
            setEmailError("Email is incorrect.");
            document.getElementById("emailErr").style.display = "inline";
            return false;
        } 
            setEmailError('');
            document.getElementById("emailErr").style.display = "none";
            return true; 
    }

    function validatePassword(){
    const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/
        if (!password.trim()) {
            setPasswordError('*Please enter the password');
            document.getElementById("passwordErr").style.display = "inline";
            return false;
        } 
        if (!regex.test(password)) {
            setPasswordError('*Password must be 8 to 20 characters long and must contain at least one number and a one special character.');
            document.getElementById("passwordErr").style.display = "inline";
            return false;
        }
        setPasswordError("");
        document.getElementById("passwordErr").style.display = "none";
        return true;
    }

    const handleBack = () => {
        document.getElementById("usernameErr").style.display = "none";
        document.getElementById("passwordErr").style.display = "none";
        document.getElementById("emailErr").style.display = "none";
        setConnectionErrorMessage("");
        setEmailError("");
        setPasswordError("");
        setUsernameError("");
        setEmail("");
        setPassword("");
        setUsername("");
        setSignIn(true);
    }

    const handleSignUpButton = () => {
        document.getElementById("usernameErr").style.display = "none";
        document.getElementById("passwordErr").style.display = "none";
        setConnectionErrorMessage("");
        setEmailError("");
        setPasswordError("");
        setUsernameError("");
        setEmail("");
        setPassword("");
        setUsername("");
        setSignIn(false);
    }

    function handleEmail(event){
        setEmail(event.target.value);
    }

  return (
    <div id='frame'>
      <div id='popup' className='content-box'>
        <div className='closeButtonContainer'>     
      <button className='closePopup' onClick={closePopup}>&times;</button>
      </div>
      <div id='popupContentWrapper'>
      <div id='popupContent'>
      <div>
        {!signIn ? (
        <h2 className='titlePopup' style={{textAlign:'center'}}>Sign Up</h2>) :
        (<h2 className='titlePopup' style={{textAlign:'center'}}>Login</h2>)}
        </div>
        <div className='inputContainer'>
            <input className='input' placeholder={signIn ? "Username" : "Username*"} onChange={handleUsername} value={username}></input>
            <p id="usernameErr" className="errorMsg" >{usernameError}</p>
            {
                !signIn && <><input id='email' ref={emailRef} className='input' type="text" placeholder="Email*" onChange={handleEmail} value={email}></input>
                             <p id="emailErr" className="errorMsg" style={{textAlign: 'start'}}>{emailError}</p> </>
            }
            <input id='password' ref={passwordRef} className='input' type="password" placeholder={signIn? "Password" : "Password*"} onChange={handlePassword} value={password}></input>
            <p id="passwordErr" className="errorMsg" style={{textAlign: 'start'}}>{passwordError}</p>
            <div className='showPassword'>
                <p>Show Password</p>
                <input type='checkbox' ref={checkboxRef} onClick={handleCheckbox}></input>
            </div>
            <p id="connectionErr" className='errorMsg' style={{textAlign : "center"}}>{connectionErrorMessage}</p>
            </div>
            <div className='signButtons'>
                { signIn ? (
        <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleSignUpButton} >Sign Up</button>) : (
        <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleBack} >Back</button>
    )}  
        { signIn ? (
        <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleLogin} >Sign In</button>) :
         (<button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleSignUp} >Sign Up</button>)
        }
        </div>
      </div>
      </div>
      </div>
    </div>
  )
}
