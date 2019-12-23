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
    display:'flex',
    width:280, 
    marginLeft:'15px',
    
  },
  divs: {
    display:'flex',
    width:'100%',
  },
}));
const Top = props =>{
  const classes = useStyles();
  const [cont,setcont] = React.useState(props.name1);
    return(

        <div className={classes.divs}>&nbsp;
          {cont&&cont.map((text,index) => (
          <div key={index} className={classes.div}>
            <Link to={text.to}><img src={text.imgsrc}/></Link>
          </div>
          ))}
        </div>
         
    );
  }
export default Top;