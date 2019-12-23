import React from 'react';
import Left from './SecondLeft';
import Right from './SecondRight';
import { makeStyles } from '@material-ui/core/styles';
import { classes } from 'istanbul-lib-coverage';
const useStyles = makeStyles(theme => ({
  div:{
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