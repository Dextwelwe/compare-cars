
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
       fetch(`http://localhost:8080/api/voiture/getModels?make=` + make, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        })
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
    console.log(make, model)
        fetch(`http://localhost:8080/api/voiture/getModelYears?make=` + make + `&model=` + model, {
             method: 'POST',
             headers: {
                 'Content-Type': 'application/json'
             },
         })
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
    


