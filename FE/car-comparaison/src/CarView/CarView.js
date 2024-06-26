import React, { useEffect, useState } from 'react'
import { getCar, getUserPreferences } from './apiCalls'
import { useParams,useNavigate } from 'react-router-dom';
import './CarView.css'
import Footer from '../footer/Footer.js';
import GeneralInfo from './GeneralInfo.js';
import Specifications from './Specifications.js';


export default function CarView({username, changes}) {
const [car, setCar] = useState('')
const [userPreferences, setUserPreferences] = useState([]);
const [infoMode, setInfoMode] = useState('General');
const { id } = useParams();
const navigate = useNavigate();

  useEffect(() => { 
    console.log("called")
    getCar(id, setCar, navigate);
    if (username !== ''){
      getUserPreferences(username, setUserPreferences);
    }
     // eslint-disable-next-line
 },[username, changes]);

  function handleInfoMode(e){
    console.log(e.target.innerHTML)
    setInfoMode(e.target.innerHTML)
  }

  return (

    <>
    {car !== "" && userPreferences !== '' &&
    <div className='rootCarView'>   
      <div className='content-box contentContainer'>
        <div className='contentCarView'>
      <div className='row1'>
      <div style={{left: '0', width:'max-content',alignSelf:'center'}}>
     {car.images &&
      <img id='imgCar' style={{borderRadius : '5px'}} src={`data:image/jpg;base64,${car.images[0].imageData}`} alt="car" width={500} height={300}/>
     }
      </div>
      <div className='row1Col2'>
        <div>
        <h2 style={{fontWeight:'600', fontSize: '25px'}}>{car.marque} {car.modele} {car.annee} {car.version}</h2>
        <h3 style={{fontWeight:'300',fontSize: '18px'}}><strong style={{fontWeight:'600'}}>Fuel consumption : </strong>{car.economieCarburant}</h3>
        <h3 style={{fontWeight:'300',fontSize: '18px'}}><strong style={{fontWeight:'600'}}>Price : </strong>{car.msrp}</h3>
        </div>
        <div>
        <button className='button' style={{marginBottom : '10px'}} onClick={()=>navigate('/compare', {state : {car}})}>Compare</button>
        </div>
      </div>
      </div>

      <section className='row2'>
        <div style={{backgroundColor : '#F7EFE5', width: '97.5%', borderRadius: '5px'}}>
      <h4 style={{padding: '5px', paddingLeft:'10px',fontSize: '20px', fontWeight:'400'}}>{car.description}</h4>
        </div>
      </section>

      <section className='row3'>
      <div className='generalInfo'>
      <div className='infoButtonList'>
        <button className='button buttonMenuInfo' style={{borderTopLeftRadius: '5px' }} onClick={(event)=>handleInfoMode(event)}>General</button>
        <button className='button buttonMenuInfo' style={{borderTopRightRadius: '5px' }} onClick={(event)=>handleInfoMode(event)}>Specifications</button>
      </div>
      <div>
     { infoMode === 'General' ?
      <GeneralInfo preferences={userPreferences} car={car}></GeneralInfo> :
      <Specifications car={car}></Specifications>
     }
      </div>
      </div>
     <div className='proConsWrapper'>
      <div className='proCons'>
        <div className='advantages'>
        <h5 className='h5'>PROS:</h5>
        <ul className='listProCons'>
        {car.avantages.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
        </div>
        

        <div className='disadvantages'> 
        <h5 className='h5'>CONS:</h5>
        <ul className='listProCons'>
        {car.desavantages.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
        </div>
        </div>
      </div>
      
      </section>
      <h3 style={{marginTop:'40px'}}>REVIEWS</h3>
      <section className='reviews'>
      <div className='reviewsContent'>
      {car.revues.length > 0 && car.revues.map((item, index) => (
      <div key={index} className='content-box ' style={{flex: '0 0 auto' ,marginLeft:'20px', marginRight:'20px', height : '250px', width:'350px', display:"flex", justifyContent:'start', alignItems:'center', overflowX:'auto', backgroundColor:'white'}}>
      <iframe width="350" height="250" src={item} title="YouTube video player" frameBorder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerPolicy="strict-origin-when-cross-origin" allowFullScreen></iframe>
    </div>
      ))}
      </div>
        </section>        
      </div>
      </div>
      </div>
      }
      <div style={{position:'relative'}}><Footer></Footer></div>
      </>
  )
}
