import React from 'react';
import { makeStyles } from '@material-ui/core/styles';

import { Link } from '@material-ui/core';

// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    position:'relative',
    width:'25%',
    height:70,
  },
  divss: {
    display:'flex',
    position:'relative',
    width:'25%',  
    height:70, 
  },
  divs: {
    top:30,
    position:'relative',
    display:'flex',
    width:'100%',
    height:70,
  },
  divimg: {
    position:'relative',
    width:'100%',
    height:70,
  }
}));
const Top = props =>{
  const classes = useStyles();
  const [ConT,setConT] =React.useState(props.name);  

    return(
      
        <div className={classes.divs}>
          {ConT&&ConT.map((text,index) => (
          <div key={index} className={classes.divss}>
            <Link to={text.to}><img className={classes.divimg} src={text.imgsrc}/></Link>
          </div>
          ))}
        </div> 
    );
  }
export default Top;