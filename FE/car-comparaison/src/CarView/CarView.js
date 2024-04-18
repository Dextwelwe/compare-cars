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
      <div className='row1'>
      <div>
     {car.images &&
      <img src={`data:image/jpg;base64,${car.images[0].imageData}`} alt="Byte Array Image" width={500} height={300}/>
     }
      </div>
      <div>
      {car.msrp}
      </div>
      </div>

      <section className='row2'>
      DESCRIPTION : {car.description}
      </section>

      <section className='row3'>
      <div className='generalInfo'>

      </div>

      <div className='proCons'>
        <div className='advantages'>

        </div>

        <div className='disadvantages'> 

        </div>
      </div>
      </section>

      <section className='reviews'>
      <div>REVIEWS</div>
        </section>        
      </div>
      </div>
      <div style={{position:'relative'}}><Footer></Footer></div>
      </>
  )
}
