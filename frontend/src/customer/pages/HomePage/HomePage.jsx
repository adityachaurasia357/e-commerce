import React from 'react'
import MainCarousel from '../../components/HomeCarousel/MainCarousel'
import HomeSectionCarousel from '../../components/HomeSectionCarousel/HomeSectionCarousel'
import { mens_kurta } from '../../../Data/mens_kurta'

export default function HomePage() {

  return (
    <div>
        <MainCarousel/>
        <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
            <HomeSectionCarousel data={mens_kurta} SectionName={"Men's Kurta"}/>
            <HomeSectionCarousel data={mens_kurta} SectionName={"Men's Shoes"}/>
            <HomeSectionCarousel data={mens_kurta} SectionName={"Men's Shirt"}/>
            <HomeSectionCarousel data={mens_kurta} SectionName={"Women's Saree"}/>
            <HomeSectionCarousel data={mens_kurta} SectionName={"Women's Dress"}/>
        </div>
    </div>
  )
}
