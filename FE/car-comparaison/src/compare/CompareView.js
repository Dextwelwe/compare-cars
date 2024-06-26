import React, {useEffect, useState} from 'react'
import { useLocation } from 'react-router-dom';
import  './compareview.css'
import { getCar } from '../CarView/apiCalls.js';
import { useNavigate} from 'react-router-dom';
import SearchBar from '../SearchBar/SearchBar.js';

export default function CompareView() {
  const location = useLocation();
  const [car, setCar] = useState([]);
  const [button, setButton] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (location.state) {
      setCar(prevArr => [...prevArr, location.state.car]);
      } 
     // eslint-disable-next-line  
  }, []);

  const addElement = (car) => {
    setCar(prevArray => [...prevArray, car]);
  };

  function setSearchPopup(){
    setButton(true)
  }

  async function handleAddCar(id){
    let newCar = await getCar(id, addElement, navigate)
    console.log('car ' + newCar)
    setButton(false)
    
     
  }

  function removeCar(id){
    let carsCopy = [...car];
    const index = carsCopy.findIndex(x => x.id === id);
    if (index !== -1) {
        carsCopy.splice(index, 1);
    }
    setCar(carsCopy);
  }

  function closePopup(e){
    console.log(e.target)
if (e.target.id === 'frame'){
  setButton(false)
}
  }
  
  return (
    <>
    {
      button && <div id='frame' onClick={(e)=> closePopup(e)}>
        <div id='popupCompare'>
        <SearchBar handle={handleAddCar}></SearchBar>
        </div>
      </div>
    }
    <div>
    <div style={{ width: '100%',  textAlign:'center', display : 'flex', justifyContent:'center'}}>
      <div style={{width : "80%", height : '100%', backgroundColor:'#FFFBF5', display:'block', minHeight : '250px',overflowY:'hidden',overflowX : 'auto'}} className='contentCompare contentContainer content-box'>
        <div style={{display : 'flex', justifyContent : 'space-between', alignItems : 'center'}}> 
        <h1 style={{ fontWeight : "600", marginTop : '0', marginBottom : '25px'}}>Compare Cars (2-5)</h1>
        <button className='button' id='buttonAddCar' onClick={setSearchPopup} disabled={car.length > 4}> Add a car </button>   
        </div>
        <div style={{display:'flex', justifyContent : 'start',overflowX : 'auto', overflowY:'hidden', flexDirection : 'column'}}>
        <div style={{display:'flex', justifyContent : 'start',overflowX : 'auto', overflowY:'hidden'}}>
       
       { car.length >0 ?(<div className='widthElement' style={{ display:'flex'}}><div className='widthElement' style={{display:'flex', alignSelf:'end', flexDirection :"column", textAlign:'start'}}> <hr style={{width:'87%', margin:'0', alignSelf:"end"}}></hr>
          <ul>
            <li>PRICE</li>
            <li className='listImemColor1'>ENGINE</li>
            <li>FUEL TYPE</li>
            <li className='listImemColor1'>AUTONOMY</li>
            <li>POWER</li>
            <li className='listImemColor1'>TORQUE</li>
            <li>ACCELERATION 0-100 km/h</li>
            <li className='listImemColor1'>INDUCTION</li>
            <li>TRANSMISSION</li>
            <li className='listImemColor1'>DRIVETRAIN </li>
            <li>VEHICULE TYPE </li>
            <li className='listImemColor1'>NUMBER OF DOORS </li>
            <li>FUEL CONSUMPTION</li>
            <li className='listImemColor1'>FUEL CONSUMPTION HIGHWAY </li>
            <li>MAX SPEED</li>
          </ul>
          </div>
          </div> ): (<div></div>)
}
          { 
              car.length > 0 ? ( car.map((item, index) => (
            <div className='widthElement' key={index} style={{display:'flex', flexDirection :'column', justifyContent:'flex-start', alignItems:'center'}}>
            <button className='button' style={{marginBottom : '-15px', marginRight : '15px',height: '24px', width: '24px', alignSelf:'end', backgroundColor : 'red', zIndex : '1001'}} onClick={()=>removeCar(item.id)}>&#x2715;</button>
            <img className='imgCompare' style={{borderRadius : '5px'}} src={`data:image/jpg;base64,${item.images[0].imageData}`} alt="car" width={250} height={150}/>
            <h2 style={{fontWeight:'600', fontSize: '20px',lineHeight : '20px'}}>{item.marque} {item.modele} {item.annee} </h2>
            <h2 style={{fontWeight:'600', fontSize: '20px', margin :"0", lineHeight : '20px'}}>{item.version} </h2>
            <div className='widthElement compareViewSpecificationList'  key={index}>
            <hr></hr>
          <ul style={{listStyleType: 'none', textAlign : 'start', padding : 0}}>
          <li>{item.msrp}</li>
           <li className='listImemColor1'>{item.moteur}</li>
           <li>{item.typeCarburant}</li>
           <li className='listImemColor1'>{item.autonomie}</li>
           <li>{item.puissance}</li>
           <li className='listImemColor1'>{item.couple}</li>
           <li >{item.acceleration}</li>
           <li className='listImemColor1'>{item.induction}</li>
           <li >{item.transmission}</li>
           <li className='listImemColor1'>{item.motricite}</li>
           <li >{item.typeCarroserie}</li>
           <li className='listImemColor1'>{item.numPortes}</li>
           <li>{item.economieCarburant}</li>
           <li className='listImemColor1'>{item.economieCarburantAutoroute}</li>
           <li>{item.vitesseMaximale}</li>
            </ul>
          </div>
              </div>))) : (<div style={{width: '100%', textAlign:'start'}}>ADD A CAR TO CONTINUE <hr></hr></div>)
          }
        </div>
        </div>  
      </div>
      </div>
      </div>
      </>
  )
}
