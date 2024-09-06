import React, { useState } from "react";
import AliceCarousel from "react-alice-carousel";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";
import { Button } from "@mui/material";
import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";
import { useRef } from "react";

const HomeSectionCarousel = ({data,SectionName}) => {
  const [currentIndex, setCurrentIndex] = useState(0);

  const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 5.5 },
  };

  const carouselRef = useRef(null);

  const slidePrev = () => {
    if (carouselRef.current && currentIndex > 0) {
      carouselRef.current.slidePrev();
      setCurrentIndex(currentIndex - 1);
    }
  };

  const slideNext = () => {
    if (
      carouselRef.current &&
      currentIndex < items.length - responsive[1024].items
    ) {
      carouselRef.current.slideNext();
      setCurrentIndex(currentIndex + 1);
    }
  };

  const handleSlideChanged = ({ item }) => {
    setCurrentIndex(item);
  };
  const items = data
    .slice(0, 10)
    .map((item) => <HomeSectionCard product={item} />);

  return (
    <div className="border">
      <h2 className="text-2xl font-extrabold text-gray-800 py-5">{SectionName}</h2>
      <div className="relative p-5">
        <AliceCarousel
          disableButtonsControls
          disableDotsControls
          items={items}
          responsive={responsive}
          ref={carouselRef}
          onSlideChanged={handleSlideChanged}
        />
        {currentIndex < items.length - responsive[1024].items && (
          <Button
            variant="contained"
            className="z-50 bg-white"
            onClick={slideNext}
            sx={{
              position: "absolute",
              top: "8rem",
              right: "0rem",
              transform: "translateX(50%) rotate(90deg)",
              bgcolor: "white",
            }}
            aria-label="next"
          >
            <KeyboardArrowLeftIcon
              sx={{ transform: "rotate(90deg)", color: "black" }}
            />
          </Button>
        )}
        {currentIndex > 0 && (
          <Button
            variant="contained"
            className="z-50 bg-white"
            onClick={slidePrev}
            sx={{
              position: "absolute",
              top: "8rem",
              left: "0rem",
              transform: "translateX(-50%) rotate(-90deg)",
              bgcolor: "white",
            }}
            aria-label="next"
          >
            <KeyboardArrowLeftIcon
              sx={{ transform: "rotate(90deg)", color: "black" }}
            />
          </Button>
        )}
      </div>
    </div>
  );
};

export default HomeSectionCarousel;
