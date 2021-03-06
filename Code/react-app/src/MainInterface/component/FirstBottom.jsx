import React from 'react';
import { makeStyles } from '@material-ui/core/styles';

import { Link } from '@material-ui/core';

// import './CSS/Center.css';
const useStyles = makeStyles(theme => ({
  div: {
    display:'flex',
    width:195, 
    marginLeft:'13.7%',
  },
  divss: {
    position:'relative',

    display:'flex',
    width:'18%',   
  },
  divs: {
    display:'flex',
    width:'100%',
  },
}));
const Top = props =>{
  const classes = useStyles();
  const [ConT,setConT] =React.useState(props.name);  

    return(
      
        <div className={classes.divs}>&nbsp;
          <div className={classes.div}>
            <img alt="loading" src="/Pic/time.png"/>
          </div>
          {ConT&&ConT.map((text,index) => (
          <div key={index} className={classes.divss}>
            <Link to={text.to}><img alt="loading" className={classes.divs} src={text.imgsrc}/></Link>
          </div>
          ))}
        </div> 
    );
  }
export default Top;