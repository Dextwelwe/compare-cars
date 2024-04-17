import React, { useEffect, useState } from 'react'
import { getCar } from './apiCalls'
import { useParams,useNavigate } from 'react-router-dom';

export default function CarView() {
const [car, setCar] = useState('')
const { id } = useParams();
const navigate = useNavigate();

  useEffect(() => { 
    getCar(id, setCar, navigate);
     // eslint-disable-next-line
 },[]);




  return (
    <div>
      
    </div>
  )
}
