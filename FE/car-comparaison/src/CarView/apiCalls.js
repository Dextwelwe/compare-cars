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
    })
    .catch(error => {
      navigate('/404')  
      console.error('There was a problem with the fetch operation:', error);
    });
  }  

  export const getUserPreferences = async (username, setUserPreferences) => {
    fetch(`http://localhost:8080/api/utilisateur/getPreferences?username=` + username )
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
