import React, { useEffect, useState } from 'react'
import { getCar } from './apiCalls'
import { useParams,useNavigate } from 'react-router-dom';
import './CarView.css'
import Header from '../header/Header.js'

export default function CarView() {
const [car, setCar] = useState('')
const { id } = useParams();
const navigate = useNavigate();

  useEffect(() => { 
    getCar(id, setCar, navigate);
     // eslint-disable-next-line
 },[]);


  return (
    <>
    <Header></Header>
    <div className='rootCarView'>   
      <div className='contentContainer'>
      <div className='row1'>
      <div>
      <img src='https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg?cs=srgb&dl=pexels-mike-bird-170811.jpg&fm=jpg' width={500} height={300}></img>
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
      </>
  )
}
