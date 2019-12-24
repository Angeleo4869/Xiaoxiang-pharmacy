import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import ListSubheader from '@material-ui/core/ListSubheader';
import Button from '@material-ui/core/Button';
//import tileData from './tileData';
//import image from '/picture/David.jpg';
const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    overflow: 'hidden',
    backgroundColor: theme.palette.background.paper,
  },
  gridList: {
    width: 700,
    height: 450,
  },
}));


  // The example data is structured as follows:
 
  

 
  const tileData = [
    {
      img: '/picture/David.jpg',
      name: '阿莫西林',
      price: '$19.9',
    },
    {
      img: '/picture/David.jpg',
      name: '阿莫西林',
      price: '$19.9',
    },
    {
      img: '/picture/yao.jpg',
      name: '阿司匹林',
      price: '$19.9',
    },
    {
      
      img: '/picture/yao.jpg',
      name: '阿司匹林',
      price: '$19.9',
    },
  ];

export default function TitlebarGridList() {
  const classes = useStyles();

  return (
    <div className={classes.root} style={{marginLeft:20}}>
      <GridList cellHeight={180} className={classes.gridList}>
        <GridListTile key="Subheader" cols={2} style={{ height: 'auto' }}>
          <ListSubheader component="div">
            当月热销
          </ListSubheader>
        </GridListTile>
        {tileData.map(tile => (
          <GridListTile key={tile.img} >
            <img src={tile.img} alt={tile.name} style={{ width:'270'}}/>
            <GridListTileBar
              title={tile.name}
              subtitle={<span>{tile.price}</span>}
              actionIcon={
                <Button size="small" variant="contained" color="secondary" >
                  查看详情
                </Button>
              }
            />
          </GridListTile>
        ))}
      </GridList>
    </div>
  );
}