import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import {withAxios } from 'react-axios'
import Data from './data';

export default function BackToTop()  {
  //得到组件
  const Hyyy=(text)=>{
    global.constants.name=text;
    alert(global.constants.name)
    console.log(text)
    // console.log(text.text)
    // console.log(text.text.Len)
    // console.log(text.text.Len.length)
    // console.log(text.text.Len[0].name)
    var i = 0;
    var len = text.text.Len.length;
    var content="";
    for(; i< len;i++){
      content+=`<h6 style='color:red'>`+text.text.Len[i].name +`</h6>`
      // +"<h6 style='color:red'>"+text.text.Len[i].age +"</h6>"
      ;
    }
    document.getElementById("t_tt").innerHTML=content;
    return null;
  }
//得到数据的数组
  const MyComponent = withAxios({
    url: 'http://localhost:8080/React_Manage2/myaction.action',
    method: "POST",
    params: {id: "12345"}
  })(class MyComponentRaw extends React.Component {
  render() {
    const {error, response, isLoading, makeRequest, axios} = this.props
    if(error) {
      return (<div>Something bad happened: {error.message}</div>)
    } else if(isLoading) {
      return (<div className="loader"></div>)
    } else if(response !== null) {
      console.log(response.data)
      //返回数据给组件处理
      return (<div><Hyyy text={response.data} /></div>)
    }
    return null
  }
})
    return (
      <div>
        <div id="t_tt">
          <MyComponent/>
          
        </div>
        <h6>{global.constants.name}</h6>
        <h6>{global.constants.name="hello"}</h6>
        
      </div>
          );
}