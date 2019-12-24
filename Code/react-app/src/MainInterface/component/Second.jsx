import React from 'react';
import Left from './SecondLeft';
import Right from './SecondRight';
import { makeStyles } from '@material-ui/core/styles';
const useStyles = makeStyles(theme => ({
  div:{
    position:'relative',
    width:'100%',
    display:'flex',
  },
}));
const Second  = props =>{
  const classes = useStyles();
    return(
            <div className={classes.div}>
                <Left/>
                <Right name={props.name}/>
            </div>
    );
  }
export default Second ;