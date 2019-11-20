import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import SearchAppbar from '../Components/Appbar';
import CarTabs from '../Components/CarTabs';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

export default function FullWidthGrid() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Grid container spacing={3}>
        <Grid item xs={12} >
          <SearchAppbar></SearchAppbar>
        </Grid>
        <Grid item xs={1} sm={1}></Grid>
        <Grid item xs={10} sm={10}>
          {/* <Paper className={classes.paper}>xs=12 sm=6</Paper> */}
          {/* 整体页面布局 */}
            <CarTabs></CarTabs>

        </Grid>
        <Grid item xs={1} sm={1}></Grid>

        
      </Grid>
    </div>
  );
}