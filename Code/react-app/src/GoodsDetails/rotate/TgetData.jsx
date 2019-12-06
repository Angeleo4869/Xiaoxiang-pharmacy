import React from 'react';
import Button from '@material-ui/core/Button';
import Fun from './test';
import './data'
function respon(){
  global.constants.name=document.getElementById("i_i");
  
  document.getElementById("req").innerHTML={Fun};
  console.log(Fun());
}
export default function (){
  return(
    // 不请求,需要渲染
    <div id="req">
      <input id="i_i"></input>
      <Button onClick={respon}>asd</Button>
      <Fun />
    </div>
  )
}