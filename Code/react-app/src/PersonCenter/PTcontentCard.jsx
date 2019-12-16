import React from 'react';
// import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

// const useStyles = makeStyles({
  
// });
var cstyle=null;
const card1= {//4列
  position:'relative',
  // marginLeft:30,
  margin:10,
  maxWidth: '100%',
  maxHeight: 300,
};
const card2= {//2列
  position:'relative',
  // marginLeft:30,
  margin:5,
  maxWidth: '90%',
  maxHeight: 300,
};

export default function ImgMediaCard(props) {
  // const classes = useStyles();
  if(props.size===1){
    cstyle=card2;
  }else{
    cstyle=card1;
  }
  return (
    <Card style={cstyle}>
      <CardActionArea style={{marginBottom:-5}}>
        <CardMedia
          component="img"
          alt="Contemplative Reptile"
          height="140"
          image={props.imagesrc}
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography noWrap={true} gutterBottom variant="h5" component="h2">
            {props.name}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            ￥{props.price}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="small" color="primary">
          Purchase
        </Button>
        
      </CardActions>
    </Card>
  );
}