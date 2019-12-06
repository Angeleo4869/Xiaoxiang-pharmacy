
import React from 'react';
import axios from 'axios';
import App from './test'
import { Button } from '@material-ui/core';
import Data from './data';
function test(props){
   
   alert( Data.getText())
axios.get('http://localhost:8080/React_Manage2/myaction.action',
     )
    .then(function (response) {
    //   alert(response.data.success)
        Data.setText(response.data.Len);
        console.log(response.data.Len)
      
    })
    .catch(function (error) {
      console.log(error);
    })
}
export default function pes(){
  // const content = Date.getText();
    return(
        <div>
            {/* {content.map(
              (Tt)=>(
                Tt
              )
            )} */}
            
        <h6 id="d_d">asd</h6>
        <Button onClick={test}>asd</Button>
        </div>
    )
}