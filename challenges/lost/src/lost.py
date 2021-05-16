#!/usr/bin/python3

from fpdf import FPDF
import random


def make_code(my_i):
	m_pre = "he2021{"

	m_pool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	m_secret = "Whatyoureallywanttodoiscountto361becausethatiswheretheeggis"
	m_plen = len(m_pool)
	m_pseclen = len(m_secret)

	m_ges = m_pre

	hint_start = 22 # LOST number is 23

	# first after HE20-

	if my_i >= hint_start and my_i < (hint_start + m_pseclen):
		m_part = m_secret[my_i - hint_start]
		for j in range (0,4):
			m_part += m_pool[random.randint(0,m_plen-1)]
		
	else:
		m_part = ""
		for m_block in range(0,5):
			m_part += m_pool[random.randint(0,m_plen-1)]

	m_ges += f"{m_part}"


	for m_blox in range(0,4):
		m_part = ""
		for m_block in range(0,5):
			m_part += m_pool[random.randint(0,m_plen-1)]
		m_ges += f"-{m_part}"

	m_ges += "}"
	return(m_ges)


my_pdf = FPDF()

my_pdf.add_page()
my_pdf.set_font("Arial", size=12)
my_pdf.cell(200, 10, txt="One of these is valid, promise", ln=1, align="C")
y = my_pdf.get_y()
print(y)

for i in range(0, 500):
	m_code = (make_code(i))
	my_pdf.set_y(y)

	if i == 360: #we start at 0
		real_secret = m_code

	m_out = f"{i+1:03} {m_code}"
	my_pdf.cell(200, 10, txt=m_out, ln=1, align="C")

	# debug print (f"{i} {m_code}")
	print (f"{m_out}")

print(f"\nCode: {real_secret}")

my_pdf.output("./lost.pdf")