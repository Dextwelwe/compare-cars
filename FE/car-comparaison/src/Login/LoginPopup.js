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
    if (!validateForm()){
        return;
    }
    const connectionRequest = {
        nomUtilisateur: username.trim(),
       motDePasse: password.trim()
    };

    fetch('http://localhost:8080/api/utilisateur/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(connectionRequest)
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                showErrConnection(response);
            }
        })
        .then(data => {
            document.getElementById("connectionErr").style.display = "none";
            setIsLogged(true)
            setUser(username)
            closePopup();
        })
        .catch(error => {
            console.log(error)
        });
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

    function validateForm() {
        let isValid = true;

        if (username.trim().length < 5 || username.trim().length > 20) {
            setUsernameError('*Username length must be between 5 and 20 characters');
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
        } else {
            setPasswordError('');
            document.getElementById("passwordErr").style.display = "none";
        }
        return isValid;
    }

    const handleSignUp = () => {
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
      <div id='popup' className='content-box' >
        <div className='closeButtonContainer'>     
      <button className='closePopup' onClick={closePopup}>&times;</button>
      </div>
      {signIn ? (
      <div id='popupContentWrapper'>
      <div id='popupContent'>
      <div>
        <h2 className='titlePopup' style={{textAlign:'center'}}>Login</h2>
        </div>
        <div className='inputContainer'>
            <input className='input' placeholder="Username" onChange={handleUsername} value={username}></input>
            <p id="usernameErr" className="errorMsg" >{usernameError}</p>
            <input id='password' ref={passwordRef} className='input' type="password" placeholder="Password" onChange={handlePassword} value={password}></input>
            <p id="passwordErr" className="errorMsg" style={{textAlign: 'start'}}>{passwordError}</p>
            <div className='showPassword'>
                <p>Show Password</p>
                <input type='checkbox' ref={checkboxRef} onClick={handleCheckbox}></input>
            </div>
            <p id="connectionErr" className='errorMsg'>{connectionErrorMessage}</p>
            </div>
            <div className='signButtons'>
        <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleSignUp} >Sign Up</button>
        <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleLogin} >Sign In</button>
        </div>
      </div>
      </div>
      ):
      (
        <div id='popupContentWrapper'>
        <div id='popupContent'>
        <div>
          <h2 className='titlePopup' style={{textAlign:'center'}}>Sign Up</h2>
          </div>
          <div className='inputContainer'>
              <input className='input' placeholder="Username*" onChange={handleUsername} value={username}></input>
              <p id="usernameErr" className="errorMsg" >{usernameError}</p>
              <input id='email' ref={emailRef} className='input' type="text" placeholder="Email*" onChange={handleEmail} value={email}></input>
              <p id="emailErr" className="errorMsg" style={{textAlign: 'start'}}>{emailError}</p>
              <input id='password' ref={passwordRef} className='input' type="password" placeholder="Password*" onChange={handlePassword} value={password}></input>
              <p id="passwordErr" className="errorMsg" style={{textAlign: 'start'}}>{passwordError}</p>  
              <div className='showPassword'>
                  <p>Show Password</p>
                  <input type='checkbox' ref={checkboxRef} onClick={handleCheckbox}></input>
              </div>
              <p id="connectionErr" className='errorMsg'>{connectionErrorMessage}</p>
              </div>
              <div className='signButtons'>
          <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={()=> setSignIn(true)} >Back</button>
          <button className='button' style={{width: '45%', boxShadow : 'none'}} onClick={handleLogin} >Sign Up</button>
          </div>
        </div>
        </div>

      )
      }
      </div>
    </div>
    
  )
}
