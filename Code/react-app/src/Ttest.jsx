import React from 'react';

export default class FetchTest extends React.Component{
    constructor(props){
      super(props);
      this.state = {
          name:[]
      }
    }
//得到数据的数组
componentDidMount(){
  fetch('http://10.136.1.219:8080/React_Manage2/myaction.action').then(function(response) { 
    // Convert to JSON  really exec JSON.parse()
    return response.json();
  }).then((j) =>{
    console.log(j); 
    this.setState({
      name:j.Len
    });
    console.log(this.state.name)
  })
}

render(){
  const classes = useStyles();
    return (
      <div>
        {this.state.name&&this.state.name.map(
          (Cont,index)=>(
            index+
            Cont.name
          )
        )}
      </div>
          );
        }
}