import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { AxiosProvider, Request, Get, Delete, Head, Post, Put, Patch, withAxios } from 'react-axios'


export default function BackToTop(props)  {
  const Hyyy=(text)=>{
    alert(props.name)
    console.log(text)
    console.log(text.text)
    console.log(text.text.Len)
    console.log(text.text.Len.length)
    console.log(text.text.Len[0].name)
    var i = 0;
    var len = text.text.Len.length;
    var content="";
    for(; i< len;i++){
      content+="<h6 style='color:red'>"+text.text.Len[i].name +"</h6>";
    }
    document.getElementById("t_tt").innerHTML=content;
    return null;
  }

  const MyComponent = withAxios({
    url: 'http://localhost:8080/React_Manage2/myaction.action',
    method: "POST",
    params: {id: "12345"}
  })(class MyComponentRaw extends React.Component {
  render() {
    const {error, response, isLoading, makeRequest, axios} = this.props
    if(error) {
      return (<div>Something bad happenedddd: {error.message}</div>)
    } else if(isLoading) {
      return (<div className="loader"></div>)
    } else if(response !== null) {
      console.log(response.data)
    return (<div><Hyyy text={response.data} /></div>)
    }
    return null
  }
})
    return (
        <div id="t_tt">
           <MyComponent/>
        </div>
          );
}