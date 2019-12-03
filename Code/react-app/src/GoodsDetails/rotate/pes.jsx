
import React from 'react';
import axios from 'axios';
import App from './test'
import { Button } from '@material-ui/core';
import Data from './data';
function test(props){
   Data.setText("dafreng");
   alert( Data.getText())
axios.get('http://localhost:8080/React_Manage2/myaction.action',
     )
    .then(function (response) {
    //   alert(response.data.success)
        
      if(response.data.success){
        window.location.href = "http://localhost:3000/PersonCenter"
      }
      else
      alert("message error")
    })
    .catch(function (error) {
      console.log(error);
    })
}
export default function pes(){
    return(
        <div>
            
            
        <h6 id="d_d">asd</h6>
        <Button onClick={test}>asd</Button>
        </div>
    )
}