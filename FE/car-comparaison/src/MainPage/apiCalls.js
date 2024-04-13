
export const getMakes = async(setMakes) => {
      await  fetch('http://localhost:8080/api/voiture/getMakes') 
      .then(response => {
        if (!response.ok) {
        }
        return response.json();
      })
      .then(data => {
        setMakes(data)
        console.log(data.sort());
      })
      .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
      });
    }

export const getModels = async (setModels, make) => {
       fetch(`http://localhost:8080/api/voiture/getModels?make=` + make)
      .then(response => {
        if (!response.ok) {
        }
        return response.json();
      })
      .then(data => {
        console.log(data)
        setModels(data)
      })
      .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
      });
    }

export const getModelYear = async (setYears, make, model) => {
        fetch(`http://localhost:8080/api/voiture/getModelYears?make=` + make + `&model=` + model)
       .then(response => {
         if (!response.ok) {
         }
         return response.json();
       })
       .then(data => {
         console.log(data)
         setYears(data)
       })
       .catch(error => {
         console.error('There was a problem with the fetch operation:', error);
       });
     }  
     
    export const getTrims = async (setTrims, make, model, year) => {

          fetch(`http://localhost:8080/api/voiture/getTrims?make=` + make + `&model=` + model + `&year=` + year)
         .then(response => {
           if (!response.ok) {
           }
           return response.json();
         })
         .then(data => {
           console.log(data)
           setTrims(data)
         })
         .catch(error => {
           console.error('There was a problem with the fetch operation:', error);
         });
       }  

    export const getCarId = async (setCarId, make,model,year,trim) => {
     const response = await fetch(`http://localhost:8080/api/voiture/getCarId?make=` + make + `&model=` + model + `&year=` + year + `&trim=` + trim)
     const data = await response.json();    
     setCarId.current = data;   
     console.log(data)
    }   

    
    


