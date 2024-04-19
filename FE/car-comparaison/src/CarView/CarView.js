import React, { useEffect, useState } from 'react'
import { getCar } from './apiCalls'
import { useParams,useNavigate } from 'react-router-dom';
import './CarView.css'
import Footer from '../footer/Footer.js';

export default function CarView() {
const [car, setCar] = useState('')
const { id } = useParams();
const navigate = useNavigate();

  useEffect(() => { 
    getCar(id, setCar, navigate);
    console.log(id)
     // eslint-disable-next-line
 },[]);

  

  return (

    <>
    {car !== "" && 
    <div className='rootCarView'>   
      <div className='content-box contentContainer'>
        <div className='contentCarView'>
      <div className='row1'>
      <div style={{left: '0'}}>
     {car.images &&
      <img style={{borderRadius : '5px'}} src={`data:image/jpg;base64,${car.images[0].imageData}`} alt="car" width={500} height={300}/>
     }
      </div>
      <div className='row1Col2'>
        <div>
        <h2>{car.marque} {car.modele} {car.annee} {car.version}</h2>
        <h3>Price : {car.msrp}</h3>
        <h3>Rating : {car.note} /5</h3>
        </div>
        <div>
        <button className='button' style={{marginBottom : '10px', backgroundColor : '#0E46A3'}} onClick={()=>navigate('/compare')}>Compare</button>
        </div>
      </div>
      </div>

      <section className='row2'>
      <h4>{car.description}</h4>
      </section>

      <section className='row3'>
      <div className='generalInfo'>
      <div className='infoButtonList'>
        <button className='button buttonMenuInfo'>General</button>
        <button className='button buttonMenuInfo'>Specifications</button>
      </div>
      <div>

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
