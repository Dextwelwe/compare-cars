export const getCar = async (id, setCar, navigate) => {
    fetch(`http://localhost:8080/api/voiture/getCar?id=` + id )
    .then(response => {
      if (!response.ok) {
      }
      return response.json();
    })
    .then(data => {
      console.log(data)
      setCar(data)
      return data;
    })
    .catch(error => {
      navigate('/404')  
      console.error('There was a problem with the fetch operation:', error);
    });
  }  

  export const getUserPreferences = async (username, setUserPreferences) => {
    await fetch(`http://localhost:8080/api/utilisateur/getPreferences?username=` + username )
    .then(response => {
      if (!response.ok) {
      }
      return response.text();
    })
    .then(data => {
      setUserPreferences(data.split(";"))
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });
  }  

  export const setUserPreferences = async (username, preferences, setUserPreferences) => {
    await fetch(`http://localhost:8080/api/utilisateur/setPreferences?username=${username}&preferences=${preferences}`,{
      
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => {
      if (!response.ok) {
      }
      return response.text();
    })
    .then(data => {
      console.log(data)
      setUserPreferences(data.split(";"))
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });
  }  


