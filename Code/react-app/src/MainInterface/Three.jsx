import React from 'react';
import Left from './ThreeLeft';
import Right from './ThreeRight';
import { makeStyles } from '@material-ui/core/styles';
import { classes } from 'istanbul-lib-coverage';
const useStyles = makeStyles(theme => ({
  div:{
    display:'flex',
  },
}));
const Three  = props =>{
  const classes = useStyles();
    return(
            <div className={classes.div}>
                <Left/>
                <Right name={props.name}/>
            </div>
    );
  }
export default Three ;