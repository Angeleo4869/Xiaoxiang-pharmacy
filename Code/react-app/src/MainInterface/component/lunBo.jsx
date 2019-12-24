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
      <Slider {...settings} style={{width:835,height:430}}>
        {this.state.name&&this.state.name.map((text,index) => (
          <div key={index} >
            <Link to={text.to}><img alt="loading" style={{width:835,height:469}} src={text.imgsrc}/></Link>
          </div>
        ))}
      </Slider>
    );
  }
}
