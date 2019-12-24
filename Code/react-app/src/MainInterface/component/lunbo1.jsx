import React from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
 import "slick-carousel/slick/slick-theme.css";
 import { Link } from '@material-ui/core';
export default class SimpleSlider extends React.Component {
  constructor(props){
    super(props);
    this.state= {name:props.name}
  }
  render() {
    var settings = {
      dots: true,
      infinite: true,
      arrows:false,
      speed: 1000,
      autoplay:true,
      slidesToShow: 1,
      slidesToScroll: 1
    };
    return (
      <Slider {...settings} style={{position:'relative',width:'100%',height:215,background:'#5e5e5e',}}>
        {this.state.name&&this.state.name.map((text,index) => (
          <div key={index} >
            <Link to={text.to}><img alt="loading" style={{position:'relative',width:'100%',height:245}} src={text.imgsrc}/></Link>
          </div>
        ))}
      </Slider>
    );
  }
}
