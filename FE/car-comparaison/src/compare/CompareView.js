import React, {useEffect, useState} from 'react'
import { useLocation } from 'react-router-dom';
import  './compareview.css'
import Footer from '../footer/Footer';

export default function CompareView() {
  const location = useLocation();
  const [car, setCar] = useState([]);

  useEffect(() => {
    if (location.state) {
      setCar(prevArr => [...prevArr, location.state.car]);
      } 
  }, []);

  const addElement = () => {
    if (car.length < 4){
    setCar(prevArray => [...prevArray, car[0]]);
    }
  };
  
  return (
    <>
    <div style={{ width: '100%',  textAlign:'center', display : 'flex', justifyContent:'center'}}>
      <div style={{width : "80%", height : '100%', backgroundColor:'#FFFBF5', display:'block'}} className='contentContainer content-box'>
        <div style={{display : 'flex', justifyContent : 'space-between', alignItems : 'center'}}> 
        <h1 style={{ fontWeight : "600", marginTop : '0', marginBottom : '25px'}}>Compare Cars</h1>
        <button className='button' onClick={addElement} > Add a car </button>   
        </div>
        <div style={{display:'flex', justifyContent : 'start'}}>
        <div style={{width : '300px'}}>
              </div>
          { 
              car.length > 0 ? ( car.map((item, index) => (
            <div key={index} style={{width : '300px',display:'flex', flexDirection :'column', justifyContent:'flex-start', alignItems:'center'}}>
            <img style={{borderRadius : '5px'}} src={`data:image/jpg;base64,${item.images[0].imageData}`} alt="car" width={250} height={150}/>
            <h2 style={{fontWeight:'600', fontSize: '20px',lineHeight : '20px'}}>{item.marque} {item.modele} {item.annee} </h2>
            <h2 style={{fontWeight:'600', fontSize: '20px', margin :"0", lineHeight : '20px'}}>{item.version} </h2>
              </div>))) : (<></>)
          }
        </div>
        <hr></hr>
       
      

          { car.length > 0 &&
        <div style={{display:'flex', justifyContent : 'start'}}>
          
          <div style={{display:'flex', flexDirection :"column", width : '300px', textAlign:'start'}}> 
          <ul>
            <li className='listImemColor1'>ENGINE</li>
            <li>FUEL TYPE</li>
            <li className='listImemColor1'>AUTONOMY</li>
            <li>POWER</li>
            <li className='listImemColor1'>TORQUE</li>
            <li>TRANSMISSION</li>
            <li className='listImemColor1'>DRIVETRAIN </li>
            <li>VEHICULE TYPE </li>
            <li className='listImemColor1'>NUMBER OF DOORS </li>
            <li>COLORS </li>
            <li className='listImemColor1'>SPECIAL CHARACTERISTICS </li>
          </ul>
          </div>
            {car.map((item, index) => (
          <div className='compareViewSpecificationList' style={{width : '300px'}} key={index}>
          <ul style={{listStyleType: 'none', textAlign : 'start', padding : 0}}>
           <li className='listImemColor1'>{item.moteur}</li>
           <li>{item.typeCarburant}</li>
           <li className='listImemColor1'>{item.autonomie}</li>
           <li>{item.puissance}</li>
           <li className='listImemColor1'>{item.couple}</li>
           <li >{item.transmission}</li>
           <li className='listImemColor1'>{item.motricite}</li>
           <li >{item.typeCarroserie}</li>
           <li className='listImemColor1'>{item.transmission}</li>
           <li>{item.numPortes}</li>
           <li className='listImemColor1'>{item.characteristiques}</li>
            </ul>
          </div>
  ))}
        </div>
}
      </div>
      </div>
     
      </>
  )
}
