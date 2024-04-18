import React, { useEffect, useState } from 'react'
import { getCar } from './apiCalls'
import { useParams,useNavigate } from 'react-router-dom';
import './CarView.css'
import Header from '../header/Header.js'
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
    <div className='rootCarView'>   
      <div className='content-box contentContainer'>
        <div className='contentCarView'>
      <div className='row1'>
      <div style={{left: '0'}}>
     {car.images &&
      <img style={{borderRadius : '5px'}} src={`data:image/jpg;base64,${car.images[0].imageData}`} alt="Byte Array Image" width={500} height={300}/>
     }
      </div>
      <div className='row1Col2'>
        <div>
        <h2>{car.marque} {car.modele} {car.annee}</h2>
        <h3>Price : {car.msrp}</h3>
        <h3>Rating : {car.note}</h3>
        </div>
        <div>
        <button className='button' style={{marginBottom : '10px'}} >Compare</button>
        </div>
      </div>
      </div>

      <section className='row2'>
      <h4>{car.description}</h4>
      </section>

      <section className='row3'>
      <div className='generalInfo'>

      </div>

      <div className='proCons'>
        <div className='advantages'>
        <h5 className='h5'>PROS:</h5>
        </div>

        <div className='disadvantages'> 
        <h5 className='h5'>CONS:</h5>
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
      <div style={{position:'relative'}}><Footer></Footer></div>
      </>
  )
}
