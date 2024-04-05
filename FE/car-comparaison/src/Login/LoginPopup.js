import React , { useState, useRef } from 'react';
import './LoginPopup.css';
import "../global.css";

export default function LoginPopup({closePopup}) {
 const [username, setUsername] = useState('');
 const [password, setPassword] = useState('');
 const [usernameError, setUsernameError] = useState('');
 const [passwordError, setPasswordError] = useState('');
 const [connectionErrorMessage, setConnectionErrorMessage] = useState('');
 const checkboxRef = useRef(null);
 const passwordRef = useRef(null);





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
                document.getElementById("connectionErr").style.display = "inline";
            } else {
                showErrConnection(response);
            }
        })
        .then(data => {
            console.log('Login successful:', data);
        })
        .catch(error => {
            console.log()
        });
    }

    function showErrConnection(code) {
        console.log(code)
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

        if (username.trim().length < 5 || username.trim().length > 50) {
            setUsernameError('*Username length must be between 5 and 50 characters');
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

  return (
    <div id='frame'>
      <div id='popup' className='content-box'>
        <div className='closeButtonContainer'>
      <button className='closePopup' onClick={closePopup}>&times;</button>
      </div>
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
        <button className='button' style={{width: '45%'}} >Sign Up</button>
        <button className='button' style={{width: '45%'}} onClick={handleLogin} >Sign In</button>
        </div>
      </div>
      </div>
    </div>
    </div>
  )
}
