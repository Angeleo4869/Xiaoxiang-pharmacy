import React, { Component } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
// import { blue } from '@material-ui/core/colors';
import PersonIcon from '@material-ui/icons/Person';
import { makeStyles } from '@material-ui/core/styles';
import CardMedia from '@material-ui/core/CardMedia';

const useStyles = makeStyles(theme => ({
  
  minimage: {
    
    position:'relative',
    margin:3,
    top:30,
    width:20,
    height:20,
    objectFit:'cover',
  }
}));
// const maximage= {
  
//   width:'100%',
//   height:'auto',
//   objectFit:'cover',
// };
export default function SimpleSlider() {
  const classes = useStyles();
    const settings = {
      customPaging: function(i) {
        return (
            <PersonIcon className={classes.minimage}/>
        );
      },
      focusOnSelect: true,
      dots: true,//点
      infinite: true,//w无限包裹内容
      speed: 500,//速度
      slidesToShow: 1,
      centerMode: true,
      centerPadding: "60px",
      slidesToScroll: 1,
      lazyLoad: true,
      pauseOnDotsHover: true,
      pauseOnFocus: true,
      autoPlay:true,
    };
    return (
        <div >
        <Slider {...settings} style={{width:360}}>
          <CustomSlide index={1} />
          <CustomSlide index={2} />
          <CustomSlide index={3} />
          <CustomSlide index={4} />
          <CustomSlide index={5} />
          <CustomSlide index={6} />
        </Slider>
        </div>
    );
  
}

class CustomSlide extends Component {
  render() {
    const { index, ...props } = this.props;
    return (
      <div {...props} style={{margin:5}}>
         <CardMedia
          component="img"
          alt="Contemplative Reptile"
          image="/Pic/D1.jpg"
          width='100%'
          height='auto'
          objectfit='cover'
          />
      </div>
    );
  }
}