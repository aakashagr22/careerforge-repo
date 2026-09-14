import os
import zipfile
import copy
import docx
from docx import Document
from docx.shared import Inches, Pt, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.enum.table import WD_TABLE_ALIGNMENT
from docx.oxml import parse_xml, OxmlElement
from docx.oxml.ns import nsdecls, qn

def generate_scoped_report():
    template_path = r'c:\Users\hp\.gemini\antigravity\scratch\careerforge-repo\7th Sem Summer Training Report Format.docx'
    output_path = r'c:\Users\hp\.gemini\antigravity\scratch\careerforge-repo\7th_Sem_Summer_Training_Report_CareerForge_Updated.docx'
    main_output_path = r'c:\Users\hp\.gemini\antigravity\scratch\careerforge-repo\7th_Sem_Summer_Training_Report_CareerForge.docx'
    artifact_path = r'C:\Users\hp\.gemini\antigravity-ide\brain\e8fe5b9f-a282-47ad-a387-86a731861690\7th_Sem_Summer_Training_Report_CareerForge.docx'

    # Extract image1.jpeg from template
    with zipfile.ZipFile(template_path) as z:
        img_data = z.read('word/media/image1.jpeg')
        with open('temp_image1.jpeg', 'wb') as f:
            f.write(img_data)

    doc_tpl = Document(template_path)
    doc = Document()

    COLOR_TEXT_MAIN = RGBColor(0, 0, 0)         # Solid Black
    HEX_BORDER_COLOR = "000000"                 # Clean Table Border

    normal_style = doc.styles['Normal']
    normal_style.font.name = 'Times New Roman'
    normal_style.font.size = Pt(12)
    normal_style.font.color.rgb = COLOR_TEXT_MAIN

    def set_margins(section):
        section.top_margin = Inches(1.0)
        section.bottom_margin = Inches(1.0)
        section.left_margin = Inches(1.5)
        section.right_margin = Inches(1.0)
        section.page_width = Inches(8.27)
        section.page_height = Inches(11.69)

    def add_chapter_heading(text):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.LEFT
        p.paragraph_format.space_before = Pt(16)
        p.paragraph_format.space_after = Pt(10)
        p.paragraph_format.line_spacing = 1.15
        p.paragraph_format.keep_with_next = True
        run = p.add_run(text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(16)
        run.font.bold = True
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_main_heading(text):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.LEFT
        p.paragraph_format.space_before = Pt(12)
        p.paragraph_format.space_after = Pt(6)
        p.paragraph_format.line_spacing = 1.15
        p.paragraph_format.keep_with_next = True
        run = p.add_run(text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(14)
        run.font.bold = True
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_sub_heading(text):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.LEFT
        p.paragraph_format.space_before = Pt(10)
        p.paragraph_format.space_after = Pt(4)
        p.paragraph_format.line_spacing = 1.15
        p.paragraph_format.keep_with_next = True
        run = p.add_run(text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(12)
        run.font.italic = True
        run.font.bold = True
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_body_paragraph(text, space_after=6):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.JUSTIFY
        p.paragraph_format.line_spacing = 1.5
        p.paragraph_format.space_after = Pt(space_after)
        run = p.add_run(text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(12)
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_bullet_item(bold_prefix, text):
        p = doc.add_paragraph(style='List Bullet')
        p.alignment = WD_ALIGN_PARAGRAPH.JUSTIFY
        p.paragraph_format.line_spacing = 1.5
        p.paragraph_format.space_after = Pt(4)
        if bold_prefix:
            run_b = p.add_run(bold_prefix)
            run_b.font.name = 'Times New Roman'
            run_b.font.size = Pt(12)
            run_b.font.bold = True
            run_b.font.color.rgb = COLOR_TEXT_MAIN
        run_t = p.add_run(text)
        run_t.font.name = 'Times New Roman'
        run_t.font.size = Pt(12)
        run_t.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_table_caption(caption_text):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        p.paragraph_format.space_before = Pt(10)
        p.paragraph_format.space_after = Pt(4)
        p.paragraph_format.keep_with_next = True
        run = p.add_run(caption_text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(10)
        run.font.bold = True
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_figure_caption(caption_text):
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        p.paragraph_format.space_before = Pt(4)
        p.paragraph_format.space_after = Pt(12)
        run = p.add_run(caption_text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(10)
        run.font.bold = True
        run.font.color.rgb = COLOR_TEXT_MAIN
        return p

    def add_placeholder_box(title, instruction, height_in_inches=2.2):
        table = doc.add_table(rows=1, cols=1)
        table.alignment = WD_TABLE_ALIGNMENT.CENTER
        table.autofit = False
        cell = table.cell(0, 0)
        cell.width = Inches(5.77)

        tcPr = cell._tc.get_or_add_tcPr()
        shd = parse_xml(f'<w:shd {nsdecls("w")} w:fill="FFFFFF"/>')
        tcPr.append(shd)

        tcBorders = parse_xml(
            f'<w:tcBorders {nsdecls("w")}>\n'
            f'  <w:top w:val="single" w:sz="4" w:space="0" w:color="888888"/>\n'
            f'  <w:left w:val="single" w:sz="4" w:space="0" w:color="888888"/>\n'
            f'  <w:bottom w:val="single" w:sz="4" w:space="0" w:color="888888"/>\n'
            f'  <w:right w:val="single" w:sz="4" w:space="0" w:color="888888"/>\n'
            f'</w:tcBorders>'
        )
        tcPr.append(tcBorders)

        p = cell.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        p.paragraph_format.space_before = Pt(int(height_in_inches * 20))
        p.paragraph_format.space_after = Pt(int(height_in_inches * 20))

        run_title = p.add_run(f"[{title.upper()}]\n")
        run_title.font.name = 'Times New Roman'
        run_title.font.size = Pt(11)
        run_title.font.bold = True
        run_title.font.color.rgb = COLOR_TEXT_MAIN

        run_inst = p.add_run(instruction)
        run_inst.font.name = 'Times New Roman'
        run_inst.font.size = Pt(9.5)
        run_inst.font.italic = True
        run_inst.font.color.rgb = RGBColor(80, 80, 80)

    def set_cell_properties(cell, bold=False, font_size=10, align=WD_ALIGN_PARAGRAPH.LEFT, text=""):
        cell.text = ""
        p = cell.paragraphs[0]
        p.alignment = align
        p.paragraph_format.space_before = Pt(3)
        p.paragraph_format.space_after = Pt(3)
        p.paragraph_format.line_spacing = 1.15
        run = p.add_run(text)
        run.font.name = 'Times New Roman'
        run.font.size = Pt(font_size)
        run.font.bold = bold
        run.font.color.rgb = COLOR_TEXT_MAIN

        tcPr = cell._tc.get_or_add_tcPr()
        shd = parse_xml(f'<w:shd {nsdecls("w")} w:fill="FFFFFF"/>')
        tcPr.append(shd)

        tcBorders = parse_xml(
            f'<w:tcBorders {nsdecls("w")}>\n'
            f'  <w:top w:val="single" w:sz="4" w:space="0" w:color="{HEX_BORDER_COLOR}"/>\n'
            f'  <w:left w:val="single" w:sz="4" w:space="0" w:color="{HEX_BORDER_COLOR}"/>\n'
            f'  <w:bottom w:val="single" w:sz="4" w:space="0" w:color="{HEX_BORDER_COLOR}"/>\n'
            f'  <w:right w:val="single" w:sz="4" w:space="0" w:color="{HEX_BORDER_COLOR}"/>\n'
            f'</w:tcBorders>'
        )
        tcPr.append(tcBorders)

        tcMar = parse_xml(
            f'<w:tcMar {nsdecls("w")}>\n'
            f'  <w:top w:w="120" w:type="dxa"/>\n'
            f'  <w:bottom w:w="120" w:type="dxa"/>\n'
            f'  <w:left w:w="160" w:type="dxa"/>\n'
            f'  <w:right w:w="160" w:type="dxa"/>\n'
            f'</w:tcMar>'
        )
        tcPr.append(tcMar)

    def add_code_block(code_text):
        table = doc.add_table(rows=1, cols=1)
        table.alignment = WD_TABLE_ALIGNMENT.CENTER
        table.autofit = False
        cell = table.cell(0, 0)
        cell.width = Inches(5.77)

        tcPr = cell._tc.get_or_add_tcPr()
        shd = parse_xml(f'<w:shd {nsdecls("w")} w:fill="FFFFFF"/>')
        tcPr.append(shd)
        tcBorders = parse_xml(
            f'<w:tcBorders {nsdecls("w")}>\n'
            f'  <w:top w:val="single" w:sz="4" w:space="0" w:color="000000"/>\n'
            f'  <w:left w:val="single" w:sz="12" w:space="0" w:color="000000"/>\n'
            f'  <w:bottom w:val="single" w:sz="4" w:space="0" w:color="000000"/>\n'
            f'  <w:right w:val="single" w:sz="4" w:space="0" w:color="000000"/>\n'
            f'</w:tcBorders>'
        )
        tcPr.append(tcBorders)

        p = cell.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.LEFT
        p.paragraph_format.space_before = Pt(4)
        p.paragraph_format.space_after = Pt(4)
        p.paragraph_format.line_spacing = 1.15
        run = p.add_run(code_text)
        run.font.name = 'Consolas'
        run.font.size = Pt(9)
        run.font.color.rgb = COLOR_TEXT_MAIN
        doc.add_paragraph().paragraph_format.space_after = Pt(6)

    # -------------------------------------------------------------
    # SECTION 1: COVER PAGE (DIRECT TRANSPLANT OF PAGE 2 OF TEMPLATE)
    # -------------------------------------------------------------
    sec_cover = doc.sections[0]
    set_margins(sec_cover)
    sec_cover.footer.is_linked_to_previous = False
    sec_cover.footer.paragraphs[0].text = ""

    pic_p = doc.add_paragraph()
    run = pic_p.add_run()
    inline_pic = run.add_picture('temp_image1.jpeg')
    blip = inline_pic._inline.xpath('.//a:blip')[0]
    img_rid = blip.get(qn('r:embed'))
    doc._body._element.remove(pic_p._p)

    body_sectPr = doc._body._element.sectPr

    # Insert Page 2 paragraphs (42 to 74) from template
    for i in range(42, 75):
        tpl_p = doc_tpl.paragraphs[i]
        cloned_p = copy.deepcopy(tpl_p._p)

        for br in cloned_p.xpath('.//w:br[@w:type="page"]'):
            br.getparent().remove(br)
        for br in cloned_p.xpath('.//w:lastRenderedPageBreak'):
            br.getparent().remove(br)

        for b in cloned_p.xpath('.//a:blip'):
            b.set(qn('r:embed'), img_rid)

        body_sectPr.addprevious(cloned_p)

    # -------------------------------------------------------------
    # SECTION 2: PRELIMINARY PAGES (Roman Numerals (ii), (iii), ...)
    # -------------------------------------------------------------
    sec_prelim = doc.add_section()
    set_margins(sec_prelim)
    sec_prelim.footer.is_linked_to_previous = False

    footer = sec_prelim.footer
    p_foot = footer.paragraphs[0]
    p_foot.alignment = WD_ALIGN_PARAGRAPH.LEFT
    p_foot.paragraph_format.space_before = Pt(6)
    r_dept = p_foot.add_run("DEPARTMENT OF INFORMATION TECHNOLOGY, BPIT")
    r_dept.font.name = "Times New Roman"
    r_dept.font.size = Pt(10)
    r_dept.font.color.rgb = RGBColor(90, 90, 90)

    p_foot.paragraph_format.tab_stops.add_tab_stop(Inches(5.77))
    p_foot.add_run("\t")

    r_pg = p_foot.add_run()
    r_pg.font.name = "Times New Roman"
    r_pg.font.size = Pt(10)
    r_pg.font.color.rgb = RGBColor(90, 90, 90)
    fld = parse_xml(r'<w:fldSimple %s w:instr="PAGE"/>' % nsdecls('w'))
    r_pg._r.append(fld)

    sectPr = sec_prelim._sectPr
    pgNumType = parse_xml(r'<w:pgNumType %s w:fmt="lowerRoman" w:start="2"/>' % nsdecls('w'))
    sectPr.append(pgNumType)

    # 1. Vision and Mission of Institute
    add_chapter_heading("BHAGWAN PARSHURAM INSTITUTE OF TECHNOLOGY")
    add_main_heading("VISION OF THE INSTITUTE")
    add_bullet_item("", "To establish a leading Global Center of Excellence in multidisciplinary education, training and research in the area of Engineering, Technology and Management.")
    add_bullet_item("", "To produce technologically competent, morally & emotionally strong and ethically sound professionals who excel in their chosen field, practice commitment to their profession and dedicate themselves to the service of mankind.")

    add_main_heading("MISSION OF THE INSTITUTE")
    add_bullet_item("", "To develop world class Laboratories and other Infrastructure conducive in acquiring latest knowledge and expertise.")
    add_bullet_item("", "To bridge the knowledge and competency gaps of institute’s fresh pass-outs vis-à-vis field requirements.")
    add_bullet_item("", "To strengthen Industry- Institute Interaction and partnership for imbibing corporate culture amongst our faculty and students.")
    add_bullet_item("", "To promote research culture among faculty and students enhancing their academic and professional confidence needed to face global challenges.")
    add_bullet_item("", "To honour commitment towards social and moral values.")

    doc.add_page_break()

    # 2. POs and WKs
    add_chapter_heading("BHAGWAN PARSHURAM INSTITUTE OF TECHNOLOGY")
    add_main_heading("PROGRAM OUTCOMES (POs)")
    pos = [
        ("Engineering Knowledge: ", "Apply knowledge of mathematics, natural science, computing, engineering fundamentals and an engineering specialization as specified in WK1 to WK4 respectively to develop the solution of complex engineering problems."),
        ("Problem Analysis: ", "Identify, formulate, review research literature and analyze complex engineering problems reaching substantiated conclusions with consideration for sustainable development. (WK1 to WK4)"),
        ("Design/Development of Solutions: ", "Design creative solutions for complex engineering problems and design/develop systems/components/processes to meet identified needs with consideration for the public health and safety, whole-life cost, net zero carbon, culture, society and environment as required. (WK5)"),
        ("Conduct Investigations of Complex Problems: ", "Conduct investigations of complex engineering problems using research-based knowledge including design of experiments, modelling, analysis & interpretation of data to provide valid conclusions. (WK8)."),
        ("Engineering Tool Usage: ", "Create, select and apply appropriate techniques, resources and modern engineering & IT tools, including prediction and modelling recognizing their limitations to solve complex engineering problems. (WK2 and WK6)"),
        ("The Engineer and The World: ", "Analyze and evaluate societal and environmental aspects while solving complex engineering problems for its impact on sustainability with reference to economy, health, safety, legal framework, culture and environment. (WK1, WK5 and WK7)."),
        ("Ethics: ", "Apply ethical principles and commit to professional ethics, human values, diversity and inclusion; adhere to national & international laws. (WK9)"),
        ("Individual and Collaborative Team work: ", "Function effectively as an individual, and as a member or leader in diverse/multi-disciplinary teams."),
        ("Communication: ", "Communicate effectively and inclusively within the engineering community and society at large, such as being able to comprehend and write effective reports and design documentation, make effective presentations considering cultural, language, and learning differences."),
        ("Project Management and Finance: ", "Apply knowledge and understanding of engineering management principles and economic decision-making and apply these to one’s own work, as a member and leader in a team, and to manage projects and in multidisciplinary environments."),
        ("Life-Long Learning: ", "Recognize the need for, and have the preparation and ability for i) independent and life-long learning ii) adaptability to new and emerging technologies and iii) critical thinking in the broadest context of technological change. (WK8)")
    ]
    for idx, (b, t) in enumerate(pos, 1):
        add_bullet_item(f"PO{idx} - {b}", t)

    add_main_heading("KNOWLEDGE AND ATTITUDE PROFILE (WK)")
    wks = [
        ("WK1: ", "A systematic, theory-based understanding of the natural sciences applicable to the discipline and awareness of relevant social sciences."),
        ("WK2: ", "Conceptually-based mathematics, numerical analysis, data analysis, statistics and formal aspects of computer and information science to support detailed analysis and modelling applicable to the discipline."),
        ("WK3: ", "A systematic, theory-based formulation of engineering fundamentals required in the engineering discipline."),
        ("WK4: ", "Engineering specialist knowledge that provides theoretical frameworks and bodies of knowledge for the accepted practice areas in the engineering discipline; much is at the forefront of the discipline."),
        ("WK5: ", "Knowledge, including efficient resource use, environmental impacts, whole-life cost, re-use of resources, net zero carbon, and similar concepts, that supports engineering design and operations in a practice area."),
        ("WK6: ", "Knowledge of engineering practice (technology) in the practice areas in the engineering discipline."),
        ("WK7: ", "Knowledge of the role of engineering in society and identified issues in engineering practice in the discipline, such as the professional responsibility of an engineer to public safety and sustainable development."),
        ("WK8: ", "Engagement with selected knowledge in the current research literature of the discipline, awareness of the power of critical thinking and creative approaches to evaluate emerging issues."),
        ("WK9: ", "Ethics, inclusive behavior and conduct. Knowledge of professional ethics, responsibilities, and norms of engineering practice. Awareness of the need for diversity by reason of ethnicity, gender, age, physical ability etc. with mutual understanding and respect, and of inclusive attitudes.")
    ]
    for b, t in wks:
        add_bullet_item(b, t)

    doc.add_page_break()

    # 3. COs and SDGs
    add_chapter_heading("BHAGWAN PARSHURAM INSTITUTE OF TECHNOLOGY")
    add_main_heading("COURSE OUTCOMES (COs)")
    add_bullet_item("CO1: ", "Apply advanced IT knowledge, domain concepts and modern tools to address assigned or real-world technical tasks.")
    add_bullet_item("CO2: ", "Analyze technical requirements/problems using systematic investigation and critical reasoning to develop appropriate solutions.")
    add_bullet_item("CO3: ", "Demonstrate effective individual/collaborative work, technical communication, project management and professional/ethical conduct.")
    add_bullet_item("CO4: ", "Demonstrate independent lifelong learning, adaptability to emerging technologies, and evaluate ethical, societal and sustainability implications.")

    add_main_heading("SUSTAINABLE DEVELOPMENT GOALS (SDGs)")
    sdgs = [
        ("SDG 1", "NO POVERTY"), ("SDG 2", "ZERO HUNGER"), ("SDG 3", "GOOD HEALTH & WELL-BEING"),
        ("SDG 4", "QUALITY EDUCATION"), ("SDG 5", "GENDER EQUALITY"), ("SDG 6", "CLEAN WATER & SANITATION"),
        ("SDG 7", "AFFORDABLE & CLEAN ENERGY"), ("SDG 8", "DECENT WORK & ECONOMIC GROWTH"),
        ("SDG 9", "INDUSTRY, INNOVATION & INFRASTRUCTURE"), ("SDG 10", "REDUCED INEQUALITIES"),
        ("SDG 11", "SUSTAINABLE CITIES & COMMUNITIES"), ("SDG 12", "RESPONSIBLE CONSUMPTION & PRODUCTION"),
        ("SDG 13", "CLIMATE ACTION"), ("SDG 14", "LIFE BELOW WATER"), ("SDG 15", "LIFE ON LAND"),
        ("SDG 16", "PEACE & JUSTICE STRONG INSTITUTIONS"), ("SDG 17", "PARTNERSHIPS FOR THE GOALS")
    ]
    tbl_sdg = doc.add_table(rows=9, cols=2)
    tbl_sdg.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_sdg.autofit = False
    for i in range(9):
        idx1 = i
        idx2 = i + 9
        c1 = tbl_sdg.cell(i, 0)
        c2 = tbl_sdg.cell(i, 1)
        c1.width = Inches(2.88)
        c2.width = Inches(2.88)
        set_cell_properties(c1, text=f"{sdgs[idx1][0]}: {sdgs[idx1][1]}", font_size=9.5)
        if idx2 < len(sdgs):
            set_cell_properties(c2, text=f"{sdgs[idx2][0]}: {sdgs[idx2][1]}", font_size=9.5)
        else:
            set_cell_properties(c2, text="", font_size=9.5)

    doc.add_page_break()

    # 4. Department Vision, Mission, PEOs, PSOs
    add_chapter_heading("DEPARTMENT OF INFORMATION TECHNOLOGY")
    add_main_heading("VISION OF THE DEPARTMENT")
    add_body_paragraph("To emerge as a centre of excellence producing globally competent and morally sound professionals in the field of Information Technology who will practice commitment to their profession and dedicate themselves to the service of mankind.")

    add_main_heading("MISSION OF THE DEPARTMENT")
    add_bullet_item("", "To develop state-of-art laboratories providing relevant practical inputs to students.")
    add_bullet_item("", "To provide strong knowledge base to students in the area of Information Technology and to train them as per the requirement of industries and research organizations.")
    add_bullet_item("", "To facilitate institute industry interaction to the benefit of stake holders and motivate teachers for the continuous improvement of their academic standards.")

    add_main_heading("PROGRAM EDUCATIONAL OBJECTIVES (PEOs)")
    add_bullet_item("PEO1: Professional Excellence and Lifelong Learning: ", "Graduates will establish themselves as competent professionals in the field of Information Technology with a strong foundation in computing principles, analytical skills, and a commitment to continuous learning, innovation, and interdisciplinary development.")
    add_bullet_item("PEO2: Industry Readiness and Innovation: ", "Graduates will contribute effectively to industry and research organizations by leveraging modern tools and technologies, demonstrating leadership, entrepreneurial skills, and the ability to adapt to rapidly changing technological environments.")
    add_bullet_item("PEO3: Ethics, Sustainability and Societal Impact: ", "Graduates will exhibit professional integrity, ethical values, and social responsibility while addressing real-world challenges, thereby contributing positively to sustainable development and national/global societal needs.")

    add_main_heading("PROGRAM SPECIFIC OUTCOMES (PSOs)")
    add_bullet_item("PSO1: Reliable Software & Information Systems: ", "Design, develop and evaluate reliable, efficient and scalable software and information systems using software engineering principles, algorithms, data structures, databases and modern computing tools. (WK2, WK4 and WK6)")
    add_bullet_item("PSO2: IT Infrastructure & Technology Selection: ", "Analyze organizational and societal information-technology needs and select appropriate computing, networking, cloud and data technologies to deliver secure, interoperable and context-appropriate IT solutions. (WK4, WK5, WK6 and WK7)")
    add_bullet_item("PSO3: Emerging Technologies & Sustainable Innovation: ", "Apply emerging technologies such as Artificial Intelligence, Big Data, Cloud Computing and related digital technologies to develop innovative, ethical and sustainable solutions for real-world problems. (WK5, WK7, WK8 and WK9)")

    doc.add_page_break()

    # 5. CO-PO-PSO Mapping
    add_chapter_heading("CO–PO-PSO MAPPING & SDG MAPPING")
    add_table_caption("Table: Course Outcomes to Program Outcomes and Specific Outcomes Mapping")
    co_matrix = [
        ["CO", "PO1", "PO2", "PO3", "PO4", "PO5", "PO6", "PO7", "PO8", "PO9", "PO10", "PO11", "PSO1", "PSO2", "PSO3"],
        ["CO1", "2", "1", "1", "-", "3", "1", "-", "1", "1", "-", "2", "3", "2", "2"],
        ["CO2", "1", "3", "3", "2", "3", "2", "1", "1", "1", "1", "2", "3", "3", "2"],
        ["CO3", "-", "-", "1", "-", "1", "1", "3", "3", "3", "2", "2", "2", "2", "1"],
        ["CO4", "1", "2", "1", "1", "2", "2", "3", "2", "2", "2", "3", "2", "2", "3"]
    ]
    tbl_co = doc.add_table(rows=5, cols=15)
    tbl_co.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_co.autofit = False
    for r_idx, row in enumerate(co_matrix):
        for c_idx, val in enumerate(row):
            cell = tbl_co.cell(r_idx, c_idx)
            cell.width = Inches(0.38)
            set_cell_properties(cell, bold=(r_idx==0 or c_idx==0), font_size=9, align=WD_ALIGN_PARAGRAPH.CENTER, text=val)

    add_main_heading("SUMMER TRAINING TO SDG MAPPING")
    add_bullet_item("SUMMER TRAINING TITLE: ", "CareerForge – Smart Placement Preparation & Collaboration Platform")
    add_bullet_item("MAPPED SUSTAINABLE DEVELOPMENT GOALS: ", "SDG 4 (Quality Education), SDG 8 (Decent Work & Economic Growth), SDG 9 (Industry, Innovation & Infrastructure), SDG 10 (Reduced Inequalities)")
    add_body_paragraph("• SDG 4 (Quality Education): Empowers students with structured semester-aware roadmaps, curated topic practice sheets, and centralized learning resources.")
    add_body_paragraph("• SDG 8 (Decent Work & Economic Growth): Bridges the skill gap between academia and corporate hiring, fostering technical employability.")
    add_body_paragraph("• SDG 9 (Industry, Innovation & Infrastructure): Leverages scalable micro-modular full-stack architecture and high-performance containerized execution.")
    add_body_paragraph("• SDG 10 (Reduced Inequalities): Democratizes access to high-quality placement resources, peer communication channels, and competitive coding practice.")

    doc.add_page_break()

    # 6. Declaration
    add_chapter_heading("DECLARATION")
    add_body_paragraph("This is to certify that the material embodied in this Summer Training Report titled “CareerForge – Smart Placement Preparation & Collaboration Platform” being submitted in the partial fulfillment of the requirements for the award of the degree of Bachelor of Technology in Information Technology is based on my original work. It is further certified that this work has not been submitted in full or in part to this university or any other university for the award of any other degree or diploma. My indebtedness to other works has been duly acknowledged at the relevant places.")

    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(48)
    p.paragraph_format.space_after = Pt(2)
    r = p.add_run("____________________________\n(Name of the Student)\nEnrollment No: [__________________]\nDepartment of Information Technology\nBhagwan Parshuram Institute of Technology, Delhi")
    r.font.name = 'Times New Roman'
    r.font.size = Pt(11)

    doc.add_page_break()

    # 7. Certificate from Institute
    add_chapter_heading("CERTIFICATE FROM THE INSTITUTE")
    add_body_paragraph("This is to certify that the work embodied in this Summer Training Report titled “CareerForge – Smart Placement Preparation & Collaboration Platform” being submitted in the partial fulfillment of the requirements for the award of the degree of Bachelor of Technology in Information Technology, is original and has been carried out by [NAME OF THE STUDENT] (Enrollment No. [____________________]) under my supervision and guidance.")
    add_body_paragraph("It is further certified that this work has not been submitted in full or in part to this university or any other university for the award of any other degree or diploma to the best of my knowledge and belief.")

    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(40)
    p.paragraph_format.space_after = Pt(2)
    r = p.add_run("______________________________________\n(Name of the Faculty Supervisor)\nDesignation\nDepartment of Information Technology\nBhagwan Parshuram Institute of Technology")
    r.font.name = 'Times New Roman'
    r.font.size = Pt(11)

    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(36)
    p.paragraph_format.space_after = Pt(2)
    r = p.add_run("______________________________________\n(Prof. Manoj Kumar Gupta)\nHOD – IT\nDepartment of Information Technology\nBhagwan Parshuram Institute of Technology")
    r.font.name = 'Times New Roman'
    r.font.size = Pt(11)

    doc.add_page_break()

    # 8. Acknowledgement
    add_chapter_heading("ACKNOWLEDGEMENT")
    add_body_paragraph("An endeavor is not complete and successful till the people who made it possible are given due credit for making it possible. I take this opportunity to thank all those who have made the endeavor successful for me.")
    add_body_paragraph("At the very onset, I thank [NAME OF THE FACULTY SUPERVISOR], my project supervisor, for giving inspiration on such an important and valuable topic, scholarly guidance, constant supervision, and encouragement to make it a success. His deep knowledge and passion for problem solving amazes and inspires me. At all crucial stages, valuable insights given by him made me take the right direction. I thank him for the countless hours spent evaluating ideas, guiding technical documentation, and refining software engineering methodologies.")
    add_body_paragraph("I extend my sincere thanks to Prof. Payal Pahwa, Principal, BPIT, and Prof. Manoj Kumar Gupta, HOD-IT, BPIT, for their regular motivation, academic support, and providing state-of-the-art laboratory facilities.")
    add_body_paragraph("I would also like to acknowledge my project team members for their seamless collaboration, technical discussions, and dedicated teamwork throughout the design, development, and testing phases.")
    add_body_paragraph("Last but not least, I especially thank my family members for their unconditional moral support, encouragement, best wishes, and patience for not giving them proper time during the study.")

    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(30)
    r = p.add_run("____________________________\n(Name of the Student)\nEnrollment No: [__________________]")
    r.font.name = 'Times New Roman'
    r.font.size = Pt(11)

    doc.add_page_break()

    # 9. Abstract (Single page, concise and crisp)
    add_chapter_heading("ABSTRACT")
    add_body_paragraph("Undergraduate engineering students face significant challenges in navigating campus placement preparation, including fragmented study resources, unstructured learning roadmaps, lack of dedicated real-time peer discussion channels, and absence of an institutional in-house competitive coding contest environment. To address these core issues, this summer training project presents CareerForge — a centralized, enterprise-grade Placement Preparation and Collaboration Platform integrated with Kernel, a specialized competitive coding contest arena.")
    add_body_paragraph("The platform is engineered into core, cohesive modules: (1) Semester-Aware Roadmaps and Topic Learning Sheets for structured technical preparation and dynamic journey progress tracking; (2) Centralized Categorized Resource Libraries for study notes and tutorial links; (3) A Real-Time WebSocket/STOMP Chat Hub supporting year-wise academic channels and 1-on-1 private messaging; and (4) Kernel, an in-house contest platform built with Next.js, featuring the Monaco code editor, sandboxed execution via a self-hosted Judge0-compatible CodeBox server (supporting Python, C++, Java, C, and JavaScript), automated test evaluation, and live leaderboards. Access is governed via secure Role-Based Access Control (RBAC) supporting Student and Administrator roles.")
    add_body_paragraph("This report presents the complete Software Development Life Cycle (SDLC) followed during the training, covering requirement specifications, system modeling (Use Case, DFDs, and Architecture), relational database schemas, module implementation, and testing matrices, demonstrating CareerForge as a robust, scalable digital ecosystem for technical placement excellence.")

    doc.add_page_break()

    # 10. List of Figures
    add_chapter_heading("LIST OF FIGURES")
    add_table_caption("Table: List of Figures in the Report")
    figs = [
        ("Figure 3.1", "Use Case Diagram of CareerForge Platform", "18"),
        ("Figure 3.2", "Data Flow Diagram (DFD Level 0 – Context Level)", "20"),
        ("Figure 3.3", "Data Flow Diagram (DFD Level 1 – Operational Level)", "21"),
        ("Figure 4.1", "Work Breakdown Structure (WBS) / System Hierarchy Chart", "24"),
        ("Figure 4.2", "High-Level System Architecture & Client-Server Communication", "26"),
        ("Figure 4.3", "User Authentication & JWT Authorization Activity Flowchart", "30"),
        ("Figure 4.4", "Real-Time WebSocket/STOMP Chat Messaging Flowchart", "32"),
        ("Figure 4.5", "Kernel & CodeBox Sandboxed Code Execution & Judging Flowchart", "34"),
        ("Figure 4.6", "Entity-Relationship (ER) Diagram of CareerForge Database", "37"),
        ("Figure 4.7", "Class Diagram of Backend Domain Entities and Services", "39"),
        ("Figure 5.1", "Student Authentication & Onboarding Interface", "42"),
        ("Figure 5.2", "Student Dashboard & Roadmap Progress Tracking View", "43"),
        ("Figure 5.3", "Interactive Placement Roadmap & Section Journey View", "44"),
        ("Figure 5.4", "Topic-Level Practice Sheets (DSA / Web Dev / AI-ML)", "45"),
        ("Figure 5.5", "Centralized Resource Library & Folder Navigation View", "46"),
        ("Figure 5.6", "Real-Time Year-Wise & 1-on-1 Student Chat Channels (WebSocket)", "47"),
        ("Figure 5.7", "Administrator Management Portal & Platform Overview", "48"),
        ("Figure 5.8", "Kernel Contest Problem Arena with Monaco Code Editor", "49"),
        ("Figure 5.9", "Kernel Live Contest Leaderboard & Scoring View", "50")
    ]
    tbl_fig = doc.add_table(rows=len(figs)+1, cols=3)
    tbl_fig.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_fig.autofit = False
    set_cell_properties(tbl_fig.cell(0, 0), bold=True, text="Figure No.")
    set_cell_properties(tbl_fig.cell(0, 1), bold=True, text="Figure Title")
    set_cell_properties(tbl_fig.cell(0, 2), bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text="Page No.")
    tbl_fig.cell(0, 0).width = Inches(1.1)
    tbl_fig.cell(0, 1).width = Inches(3.87)
    tbl_fig.cell(0, 2).width = Inches(0.8)

    for i, (fn, ft, pn) in enumerate(figs, 1):
        c0 = tbl_fig.cell(i, 0)
        c1 = tbl_fig.cell(i, 1)
        c2 = tbl_fig.cell(i, 2)
        c0.width = Inches(1.1)
        c1.width = Inches(3.87)
        c2.width = Inches(0.8)
        set_cell_properties(c0, bold=True, text=fn)
        set_cell_properties(c1, text=ft)
        set_cell_properties(c2, align=WD_ALIGN_PARAGRAPH.CENTER, text=pn)

    doc.add_page_break()

    # 11. List of Tables
    add_chapter_heading("LIST OF TABLES")
    add_table_caption("Table: List of Tables in the Report")
    tbls = [
        ("Table 1.1", "CareerForge System Stakeholders & Roles (Student & Admin)", "4"),
        ("Table 3.1", "Hardware & Environment Specifications", "14"),
        ("Table 3.2", "Software Stack and Dependency Frameworks", "15"),
        ("Table 3.3", "Functional Requirements Matrix (FR-01 to FR-10)", "16"),
        ("Table 4.1", "Database Schema: users Table Specification", "27"),
        ("Table 4.2", "Database Schema: roadmaps, sections & questions Tables", "28"),
        ("Table 4.3", "Database Schema: chat_messages & chat_rooms Tables", "29"),
        ("Table 4.4", "Database Schema: Kernel Contests & Submissions Tables", "30"),
        ("Table 6.1", "Test Suite 1: Authentication & Roadmaps Unit/Integration Tests", "54"),
        ("Table 6.2", "Test Suite 2: WebSocket STOMP Messaging & Kernel Judge Tests", "56")
    ]
    tbl_t = doc.add_table(rows=len(tbls)+1, cols=3)
    tbl_t.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_t.autofit = False
    set_cell_properties(tbl_t.cell(0, 0), bold=True, text="Table No.")
    set_cell_properties(tbl_t.cell(0, 1), bold=True, text="Table Title")
    set_cell_properties(tbl_t.cell(0, 2), bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text="Page No.")
    tbl_t.cell(0, 0).width = Inches(1.1)
    tbl_t.cell(0, 1).width = Inches(3.87)
    tbl_t.cell(0, 2).width = Inches(0.8)

    for i, (tn, tt, pn) in enumerate(tbls, 1):
        c0 = tbl_t.cell(i, 0)
        c1 = tbl_t.cell(i, 1)
        c2 = tbl_t.cell(i, 2)
        c0.width = Inches(1.1)
        c1.width = Inches(3.87)
        c2.width = Inches(0.8)
        set_cell_properties(c0, bold=True, text=tn)
        set_cell_properties(c1, text=tt)
        set_cell_properties(c2, align=WD_ALIGN_PARAGRAPH.CENTER, text=pn)

    doc.add_page_break()

    # 12. Table of Contents
    add_chapter_heading("TABLE OF CONTENTS")
    toc_items = [
        ("Vision and Mission of the Institute", "(ii)", True),
        ("Program Outcomes (POs) and Knowledge & Attitude Profile (WKs)", "(iii)", True),
        ("Course Outcomes (COs) and Sustainable Development Goals (SDGs)", "(iv)", True),
        ("Vision, Mission, PEOs and PSOs of the Department", "(v)", True),
        ("CO-PO-PSO Mapping and Summer Training to SDG Mapping", "(vi)", True),
        ("Declaration", "(vii)", True),
        ("Certificate from the Institute", "(viii)", True),
        ("Acknowledgement", "(ix)", True),
        ("Abstract", "(x)", True),
        ("List of Figures", "(xi)", True),
        ("List of Tables", "(xii)", True),
        ("", "", False),
        ("CHAPTER 1: INTRODUCTION", "1", True),
        ("   1.1 Background and Context", "1", False),
        ("   1.2 Motivation", "2", False),
        ("   1.3 Project Overview", "3", False),
        ("   1.4 Target Audience and Project Scope", "4", False),
        ("   1.5 Team Responsibilities & Work Allocation", "5", False),
        ("CHAPTER 2: PROBLEM STATEMENT & OBJECTIVES", "6", True),
        ("   2.1 Problem Definition", "6", False),
        ("   2.2 Core Objectives of CareerForge", "8", False),
        ("   2.3 Proposed Solution Paradigm", "9", False),
        ("CHAPTER 3: SYSTEM ANALYSIS & SPECIFICATION", "11", True),
        ("   3.1 Software Requirement Specifications (SRS)", "11", False),
        ("       3.1.1 Functional Requirements of the Project", "11", False),
        ("       3.1.2 Non-Functional Requirements of the Project", "13", False),
        ("   3.2 Feasibility Study", "15", False),
        ("       3.2.1 Technical Feasibility", "15", False),
        ("       3.2.2 Operational Feasibility", "16", False),
        ("       3.2.3 Economic Feasibility", "16", False),
        ("       3.2.4 Schedule and Behavioral Feasibility", "17", False),
        ("   3.3 Tools, Technologies & Platform Used", "17", False),
        ("   3.4 System Modeling Diagrams", "20", False),
        ("       3.4.1 Use Case Modeling (Student & Admin)", "20", False),
        ("       3.4.2 Data Flow Diagrams (Context Level DFD 0, DFD Level 1)", "22", False),
        ("CHAPTER 4: SYSTEM DESIGN & ARCHITECTURE", "25", True),
        ("   4.1 Work Breakdown Structure (WBS)", "25", False),
        ("   4.2 Detailed Explanation of System Modules", "27", False),
        ("       4.2.1 Authentication & RBAC Security Module (Spring Boot)", "27", False),
        ("       4.2.2 Journey & Semester-Aware Roadmaps Module (Aman)", "28", False),
        ("       4.2.3 Centralized Resource Management Module", "29", False),
        ("       4.2.4 Real-Time WebSocket Chat Hub (Akash)", "30", False),
        ("       4.2.5 Contest Platform — Kernel & CodeBox Engine (Kushagra)", "31", False),
        ("       4.2.6 Unified Responsive Frontend Architecture (Vivek)", "33", False),
        ("   4.3 Flow Charts & Activity Diagrams", "34", False),
        ("   4.4 Database Schema & Class Hierarchy Design", "37", False),
        ("CHAPTER 5: IMPLEMENTATION & CODE STRUCTURE", "42", True),
        ("   5.1 User Interface Screenshots & Visual Walkthrough", "42", False),
        ("       5.1.1 CareerForge Core Module Screenshots", "42", False),
        ("       5.1.2 Kernel Competitive Coding Arena Screenshots", "49", False),
        ("   5.2 Key Source Code Implementation Modules", "51", False),
        ("       5.2.1 WebSocket STOMP Message Broker Configuration (Akash)", "51", False),
        ("       5.2.2 Roadmap Progress Calculation & Service Logic (Aman)", "52", False),
        ("       5.2.3 Kernel Monaco & CodeBox Execution Pipeline (Kushagra)", "53", False),
        ("CHAPTER 6: TESTING & QUALITY ASSURANCE", "54", True),
        ("   6.1 Testing Methodologies & Strategy", "54", False),
        ("   6.2 Test Case Specifications & Execution Matrices", "55", False),
        ("CHAPTER 7: SUMMARY & CONCLUSION", "58", True),
        ("   7.1 Summary of Work Accomplished", "58", False),
        ("   7.2 Key Academic & Technical Learnings", "59", False),
        ("   7.3 Conclusion", "60", False),
        ("CHAPTER 8: LIMITATIONS & FUTURE SCOPE", "61", True),
        ("   8.1 Limitations of Current System", "61", False),
        ("   8.2 Future Scope & Proposed Enhancements", "62", False),
        ("BIBLIOGRAPHY & REFERENCES (OFFICIAL DOCUMENTATION)", "63", True),
        ("APPENDICES", "65", True)
    ]

    for title, pg, is_bold in toc_items:
        if not title:
            doc.add_paragraph().paragraph_format.space_after = Pt(2)
            continue
        p = doc.add_paragraph()
        p.paragraph_format.line_spacing = 1.15
        p.paragraph_format.space_after = Pt(2)
        p.paragraph_format.tab_stops.add_tab_stop(Inches(5.77), docx.enum.text.WD_TAB_ALIGNMENT.RIGHT, docx.enum.text.WD_TAB_LEADER.DOTS)
        r_t = p.add_run(title)
        r_t.font.name = 'Times New Roman'
        r_t.font.size = Pt(11)
        r_t.font.bold = is_bold
        p.add_run("\t")
        r_p = p.add_run(pg)
        r_p.font.name = 'Times New Roman'
        r_p.font.size = Pt(11)
        r_p.font.bold = is_bold

    # -------------------------------------------------------------
    # SECTION 3: NUMERIC NUMBERED CHAPTERS (Starting at 1)
    # -------------------------------------------------------------
    sec_body = doc.add_section()
    set_margins(sec_body)
    sec_body.footer.is_linked_to_previous = False

    footer_b = sec_body.footer
    p_b_foot = footer_b.paragraphs[0]
    p_b_foot.alignment = WD_ALIGN_PARAGRAPH.LEFT
    p_b_foot.paragraph_format.space_before = Pt(6)
    r_dept = p_b_foot.add_run("DEPARTMENT OF INFORMATION TECHNOLOGY, BPIT")
    r_dept.font.name = "Times New Roman"
    r_dept.font.size = Pt(10)
    r_dept.font.color.rgb = RGBColor(90, 90, 90)

    p_b_foot.paragraph_format.tab_stops.add_tab_stop(Inches(5.77))
    p_b_foot.add_run("\t")

    r_b_pg = p_b_foot.add_run()
    r_b_pg.font.name = "Times New Roman"
    r_b_pg.font.size = Pt(10)
    r_b_pg.font.color.rgb = RGBColor(90, 90, 90)
    fld = parse_xml(r'<w:fldSimple %s w:instr="PAGE"/>' % nsdecls('w'))
    r_b_pg._r.append(fld)

    sectPr_b = sec_body._sectPr
    pgNumType_b = parse_xml(r'<w:pgNumType %s w:fmt="decimal" w:start="1"/>' % nsdecls('w'))
    sectPr_b.append(pgNumType_b)

    # -------------------------------------------------------------
    # CHAPTER 1: INTRODUCTION
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 1: INTRODUCTION")
    add_main_heading("1.1 Background and Context")
    add_body_paragraph("In recent years, the technical placement recruitment process across top product companies and engineering firms has evolved significantly. To succeed, undergraduate engineering students must develop competence across multiple foundational domains: algorithmic problem solving, full-stack software development, database design, and real-time collaboration.")
    add_body_paragraph("However, students traditionally encounter severe friction during placement preparation. Learning materials are scattered across disconnected websites, syllabus roadmaps lack semester-wise clarity, peer communication is lost in noisy social media groups, and colleges lack private competitive coding platforms to assess and evaluate students in real-time.")

    add_main_heading("1.2 Motivation")
    add_body_paragraph("CareerForge was conceived to solve these core issues by providing an integrated, all-in-one placement preparation ecosystem. The primary motivation is to give students a structured, semester-aware learning roadmap, centralized resources, distraction-free real-time peer discussion channels, and an in-house coding contest arena (Kernel) with automated judging.")

    add_main_heading("1.3 Project Overview")
    add_body_paragraph("CareerForge brings together four core pillars of placement preparation into a single cohesive platform:")
    add_bullet_item("1. Journey & Roadmaps: ", "Curated, semester-aware technology roadmaps and topic practice sheets with interactive completion checklists and progress tracking.")
    add_bullet_item("2. Centralized Resources: ", "Structured subject folders containing verified tutorials, notes, and study links.")
    add_bullet_item("3. Real-Time Chat Hub: ", "Low-latency WebSocket (STOMP) chat channels for year-wise peer discussions (1st, 2nd, 3rd, 4th year) and direct 1-on-1 messaging.")
    add_bullet_item("4. Contest Platform (Kernel): ", "An institutional competitive coding environment featuring in-browser Monaco code editing, sandboxed execution via a self-hosted Judge0-compatible CodeBox server, and real-time contest leaderboards.")

    add_main_heading("1.4 Target Audience and Project Scope")
    add_body_paragraph("The platform is designed for two primary stakeholder roles:")
    add_table_caption("Table 1.1: CareerForge System Stakeholders & Roles")
    tbl_roles = doc.add_table(rows=3, cols=3)
    tbl_roles.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_roles.autofit = False
    set_cell_properties(tbl_roles.cell(0, 0), bold=True, text="User Role")
    set_cell_properties(tbl_roles.cell(0, 1), bold=True, text="Target User")
    set_cell_properties(tbl_roles.cell(0, 2), bold=True, text="Platform Capabilities")
    tbl_roles.cell(0, 0).width = Inches(1.3)
    tbl_roles.cell(0, 1).width = Inches(1.5)
    tbl_roles.cell(0, 2).width = Inches(2.97)

    role_data = [
        ("Student", "1st to 4th Year B.Tech Students", "Access semester roadmaps, check off solved questions, track journey progress, access resources, participate in real-time chat, and solve coding problems in Kernel contests."),
        ("Admin", "T&P Cell, Faculty Coordinators", "Manage user accounts, curate and manage roadmaps & resources, supervise chat channels, create and schedule Kernel contests, and view platform metrics.")
    ]
    for i, (r_name, r_grp, r_desc) in enumerate(role_data, 1):
        c0, c1, c2 = tbl_roles.cell(i, 0), tbl_roles.cell(i, 1), tbl_roles.cell(i, 2)
        c0.width, c1.width, c2.width = Inches(1.3), Inches(1.5), Inches(2.97)
        set_cell_properties(c0, bold=True, text=r_name)
        set_cell_properties(c1, text=r_grp)
        set_cell_properties(c2, text=r_desc)

    add_main_heading("1.5 Team Responsibilities & Work Allocation")
    add_body_paragraph("The project was engineered collaboratively with a clear division of technical responsibilities:")
    add_bullet_item("Akash: ", "Spearheaded the Real-Time Chat subsystem and overall Spring Boot backend architecture, implementing WebSocket/STOMP duplex messaging brokers, message persistence, user authentication, and relational database schema design.")
    add_bullet_item("Aman: ", "Engineered the Journey & Roadmap subsystem, designing the hierarchical roadmap data structures, topic practice sheets, question checklists, and dynamic student progress calculation algorithms.")
    add_bullet_item("Kushagra: ", "Engineered the Contest Platform (Kernel), developing the Next.js full-stack contest arena, Monaco code editor integration, CodeBox Judge0 execution pipeline, multi-language runner, and contest leaderboard.")
    add_bullet_item("Vivek: ", "Led the Frontend Architecture across the entire platform, creating responsive, modern user interfaces with React, Next.js, TypeScript, Tailwind CSS, and client-side state caching.")

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 2: PROBLEM STATEMENT & OBJECTIVES
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 2: PROBLEM STATEMENT & OBJECTIVES")
    add_main_heading("2.1 Problem Definition")
    add_body_paragraph("Students preparing for technical campus interviews encounter multiple hurdles:")
    add_bullet_item("1. Unstructured Preparation: ", "Lack of a day-to-day semester progression map tailored for target roles (SDE, Web Dev, AI/ML).")
    add_bullet_item("2. Fragmented Resources: ", "Study materials and practice sheets are scattered across disjoint drives and portals.")
    add_bullet_item("3. Noisy Communication: ", "Academic discussions on WhatsApp/Telegram are mixed with casual chatter without year-wise segregation.")
    add_bullet_item("4. Lack of In-House Contests: ", "Colleges lack dedicated private contest infrastructure to evaluate batch coding skills under timed conditions.")

    add_main_heading("2.2 Core Objectives of CareerForge")
    add_bullet_item("Objective 1 — Structured Roadmaps: ", "To provide curated semester-aware roadmaps and topic sheets that allow students to check off questions and monitor completion percentages.")
    add_bullet_item("Objective 2 — Centralized Resource Library: ", "To provide organized folder directories for subject notes, guides, and practice links.")
    add_bullet_item("Objective 3 — Real-Time Peer Chat: ", "To provide low-latency, year-wise WebSocket chat rooms and private direct messaging.")
    add_bullet_item("Objective 4 — Competitive Coding Arena: ", "To deliver an in-house contest portal (Kernel) with Monaco editor, sandboxed CodeBox judging, and live leaderboards.")

    add_main_heading("2.3 Proposed Solution Paradigm")
    add_body_paragraph("CareerForge solves these challenges through a unified multi-tiered architecture featuring Spring Boot 3 REST and WebSocket services, Next.js contest services, PostgreSQL storage, and sandboxed CodeBox execution.")

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 3: SYSTEM ANALYSIS & SPECIFICATION
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 3: SYSTEM ANALYSIS & SPECIFICATION")
    add_main_heading("3.1 Software Requirement Specifications (SRS)")
    add_sub_heading("3.1.1 Functional Requirements of the Project")
    frs = [
        ("FR-01: User Authentication & RBAC: ", "The system shall allow users to register and log in securely, generating JWT tokens for STUDENT and ADMIN roles."),
        ("FR-02: Roadmap & Section Traversal: ", "The system shall display hierarchical semester roadmaps, allowing students to check off solved questions and track progress."),
        ("FR-03: Topic Practice Sheets: ", "The system shall provide curated topic-level sheets (DSA, Web Dev, AI/ML) with individual checkboxes and progress rings."),
        ("FR-04: Centralized Resource Folders: ", "The system shall organize learning materials into categorized subject folders."),
        ("FR-05: Real-Time WebSocket Group Chat: ", "The system shall support bi-directional WebSocket messaging in year-wise public rooms (1st, 2nd, 3rd, 4th Year)."),
        ("FR-06: 1-on-1 Direct Peer Messaging: ", "The system shall allow students to communicate privately in direct 1-on-1 chat channels."),
        ("FR-07: Kernel Contest Participation: ", "Kernel shall allow students to join timed contests via unique codes and view contest problem statements."),
        ("FR-08: In-Browser Monaco Code Editor: ", "Kernel shall provide an in-browser code editor supporting Python, C++, Java, C, and JavaScript."),
        ("FR-09: CodeBox Sandboxed Judging: ", "Kernel shall execute student code via the CodeBox Judge0 server against sample and evaluation test cases in parallel."),
        ("FR-10: Real-Time Contest Leaderboard: ", "Kernel shall calculate participant scores based on test cases passed and update live rankings.")
    ]
    for b, t in frs:
        add_bullet_item(b, t)

    add_sub_heading("3.1.2 Non-Functional Requirements of the Project")
    add_bullet_item("NFR-01: Performance & Latency: ", "REST API responses shall be delivered in under 200 ms; WebSocket message broadcast latency shall not exceed 50 ms.")
    add_bullet_item("NFR-02: Security & Isolation: ", "Passwords shall be hashed with BCrypt (strength 12). CodeBox code execution shall run in isolated sandbox environments.")
    add_bullet_item("NFR-03: Scalability: ", "The stateless backend architecture shall support horizontal scaling to accommodate 5,000+ concurrent students.")
    add_bullet_item("NFR-04: Reliability & Data Integrity: ", "PostgreSQL shall enforce ACID transactional consistency with automated schema migrations.")

    add_main_heading("3.2 Feasibility Study")
    add_body_paragraph("3.2.1 Technical Feasibility: The project utilizes Java 21, Spring Boot 3, React 18, Next.js 16, TypeScript, and PostgreSQL. All frameworks are mature, stable, and well-supported.")
    add_body_paragraph("3.2.2 Operational Feasibility: The intuitive UI seamlessly fits into the daily academic workflow of BPIT students and placement faculty.")
    add_body_paragraph("3.2.3 Economic Feasibility: Built entirely on open-source libraries and containerized with Docker, resulting in minimal infrastructure expenses.")
    add_body_paragraph("3.2.4 Schedule Feasibility: The development was completed across Agile milestones within the 7th semester summer training period.")

    add_main_heading("3.3 Tools, Technologies & Platform Used")
    add_table_caption("Table 3.2: Software Stack and Dependency Frameworks")
    tbl_tech = doc.add_table(rows=8, cols=3)
    tbl_tech.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_tech.autofit = False
    set_cell_properties(tbl_tech.cell(0, 0), bold=True, text="Subsystem / Layer")
    set_cell_properties(tbl_tech.cell(0, 1), bold=True, text="Technology & Version")
    set_cell_properties(tbl_tech.cell(0, 2), bold=True, text="Technical Purpose")
    tbl_tech.cell(0, 0).width = Inches(1.5)
    tbl_tech.cell(0, 1).width = Inches(1.5)
    tbl_tech.cell(0, 2).width = Inches(2.77)

    tech_data = [
        ("Core Backend (Akash)", "Java 21 / Spring Boot 3.2", "REST controllers, JPA repositories, Flyway schema migrations"),
        ("Real-Time Chat (Akash)", "Spring WebSocket / STOMP", "Low-latency duplex communication for year-wise & 1-on-1 chat"),
        ("Roadmaps & Journey (Aman)", "Spring Data JPA / PostgreSQL", "Hierarchical roadmap services and progress tracking algorithms"),
        ("Contest Engine (Kushagra)", "Next.js 16 / React 19 / Monaco", "Contest arena, in-browser code editor, and live leaderboard"),
        ("Execution Server", "CodeBox (Judge0-Compatible)", "Isolated multi-language code compilation and parallel test runner"),
        ("Frontend UI (Vivek)", "React 18 / TypeScript / Vite", "Responsive Single Page Application with Tailwind CSS styling"),
        ("Database Layer", "PostgreSQL 16", "ACID relational persistence for users, roadmaps, chat, and contests")
    ]
    for i, (l, t, p_desc) in enumerate(tech_data, 1):
        c0, c1, c2 = tbl_tech.cell(i, 0), tbl_tech.cell(i, 1), tbl_tech.cell(i, 2)
        c0.width, c1.width, c2.width = Inches(1.5), Inches(1.5), Inches(2.77)
        set_cell_properties(c0, bold=True, text=l)
        set_cell_properties(c1, text=t)
        set_cell_properties(c2, text=p_desc)

    add_main_heading("3.4 System Modeling Diagrams")
    add_placeholder_box("Figure 3.1: Use Case Diagram", "Insert Use Case Diagram showing Student and Admin interactions with Roadmaps, Resources, Chat, and Kernel Contests.", height_in_inches=2.0)
    add_figure_caption("Figure 3.1: Use Case Diagram of CareerForge Platform")

    add_placeholder_box("Figure 3.2: DFD Level 0 (Context Diagram)", "Insert Context DFD showing Student, Admin, CareerForge & Kernel Platform, CodeBox Server, and PostgreSQL Database.", height_in_inches=1.8)
    add_figure_caption("Figure 3.2: Data Flow Diagram (DFD Level 0 – Context Level)")

    add_placeholder_box("Figure 3.3: DFD Level 1 (Operational Diagram)", "Insert DFD Level 1 showing decomposed processes: 1.0 Auth, 2.0 Roadmaps & Progress, 3.0 Chat Hub, 4.0 Kernel Contests, and 5.0 CodeBox Judge.", height_in_inches=2.0)
    add_figure_caption("Figure 3.3: Data Flow Diagram (DFD Level 1 – Operational Level)")

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 4: SYSTEM DESIGN & ARCHITECTURE
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 4: SYSTEM DESIGN & ARCHITECTURE")
    add_main_heading("4.1 Work Breakdown Structure (WBS)")
    add_body_paragraph("The platform architecture is organized into four core functional subsystems:")
    add_bullet_item("1.0 Authentication & User Security: ", "JWT generation, BCrypt password hashing, and role validation.")
    add_bullet_item("2.0 Journey & Academic Roadmaps (Aman): ", "Semester roadmaps, practice sheets, question checklists, and progress calculations.")
    add_bullet_item("3.0 Real-Time Chat Hub (Akash): ", "WebSocket STOMP message brokers, year channels, and direct messaging.")
    add_bullet_item("4.0 Kernel Contest Platform (Kushagra): ", "Monaco editor integration, CodeBox Judge0 code execution, and leaderboards.")
    add_bullet_item("5.0 Frontend & UI Architecture (Vivek): ", "Responsive components, layout styling, and client state caching.")

    add_placeholder_box("Figure 4.1: Work Breakdown Structure (WBS)", "Insert WBS hierarchy tree chart showing the modular breakdown across the platform.", height_in_inches=1.8)
    add_figure_caption("Figure 4.1: Work Breakdown Structure (WBS) / System Hierarchy Chart")

    add_placeholder_box("Figure 4.2: High-Level System Architecture", "Insert multi-tier Architecture diagram: Client UI -> Spring Boot & Next.js -> CodeBox Server -> PostgreSQL.", height_in_inches=2.0)
    add_figure_caption("Figure 4.2: High-Level System Architecture & Client-Server Communication")

    add_main_heading("4.2 Detailed Explanation of System Modules")
    add_sub_heading("4.2.1 Authentication & RBAC Security Module")
    add_body_paragraph("Handles user registration, login, and JWT generation. Uses BCrypt (strength 12) for secure password storage and enforces role-based endpoint security for Student and Admin.")

    add_sub_heading("4.2.2 Journey & Semester-Aware Roadmaps Module (Aman)")
    add_body_paragraph("Delivers structured learning paths organized by semester and target career profile. Enables students to check off solved questions and dynamically calculates section and roadmap completion percentages.")

    add_sub_heading("4.2.3 Centralized Resource Management Module")
    add_body_paragraph("Organizes curated tutorial links, study guides, and subject documentation into categorized topic directories for fast, distraction-free access.")

    add_sub_heading("4.2.4 Real-Time WebSocket Chat Hub (Akash)")
    add_body_paragraph("Provides low-latency duplex messaging powered by Spring WebSocket over STOMP. Features public year-wise rooms (1st, 2nd, 3rd, 4th Year) and private 1-on-1 peer channels with persistent message storage.")

    add_sub_heading("4.2.5 Contest Platform — Kernel & CodeBox Engine (Kushagra)")
    add_body_paragraph("A full-stack Next.js contest platform featuring the in-browser Monaco code editor. Connects to a self-hosted Judge0-compatible CodeBox server to run sample test cases in real-time and execute all evaluation test cases in parallel upon submission, updating live contest leaderboards.")

    add_sub_heading("4.2.6 Unified Responsive Frontend Architecture (Vivek)")
    add_body_paragraph("Constructed using React 18, Next.js, TypeScript, and Tailwind CSS. Features modular reusable components, fast client-side navigation, dark/light theme toggles, and reactive state management.")

    add_main_heading("4.3 Flow Charts & Activity Diagrams")
    add_placeholder_box("Figure 4.3: User Authentication Activity Flowchart", "Insert flowchart showing Login -> BCrypt Check -> JWT Token Generation -> Protected API Access.", height_in_inches=1.8)
    add_figure_caption("Figure 4.3: User Authentication & JWT Authorization Activity Flowchart")

    add_placeholder_box("Figure 4.4: WebSocket STOMP Messaging Flowchart", "Insert flowchart showing WebSocket Handshake -> STOMP Subscribe -> Message Publish -> Broadcast to Room.", height_in_inches=1.8)
    add_figure_caption("Figure 4.4: Real-Time WebSocket/STOMP Chat Messaging Flowchart")

    add_placeholder_box("Figure 4.5: Kernel Judging Lifecycle Flowchart", "Insert flowchart showing Student Code in Monaco -> Run (Sample Cases) / Submit -> CodeBox Parallel Execution -> Score Calculation -> Leaderboard Update.", height_in_inches=1.8)
    add_figure_caption("Figure 4.5: Kernel & CodeBox Sandboxed Code Execution & Judging Flowchart")

    add_main_heading("4.4 Database Schema & Class Hierarchy Design")
    add_placeholder_box("Figure 4.6: Entity-Relationship (ER) Diagram", "Insert ER Diagram showing users, roadmaps, sections, questions, chat_messages, contests, and submissions.", height_in_inches=2.0)
    add_figure_caption("Figure 4.6: Entity-Relationship (ER) Diagram of CareerForge Database")

    add_placeholder_box("Figure 4.7: Class Diagram of Backend Domain Entities", "Insert Class Diagram showing Spring Boot entities, controllers, services, and Kernel contest models.", height_in_inches=2.0)
    add_figure_caption("Figure 4.7: Class Diagram of Backend Domain Entities and Services")

    add_table_caption("Table 4.1: Database Schema — users Table")
    tbl_u = doc.add_table(rows=5, cols=4)
    tbl_u.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_u.autofit = False
    set_cell_properties(tbl_u.cell(0, 0), bold=True, text="Column Name")
    set_cell_properties(tbl_u.cell(0, 1), bold=True, text="Data Type")
    set_cell_properties(tbl_u.cell(0, 2), bold=True, text="Constraints")
    set_cell_properties(tbl_u.cell(0, 3), bold=True, text="Description")
    tbl_u.cell(0, 0).width = Inches(1.2)
    tbl_u.cell(0, 1).width = Inches(1.1)
    tbl_u.cell(0, 2).width = Inches(1.3)
    tbl_u.cell(0, 3).width = Inches(2.17)

    u_cols = [
        ("id", "UUID", "PRIMARY KEY", "Unique user identifier"),
        ("email", "VARCHAR(100)", "UNIQUE, NOT NULL", "College email address"),
        ("password", "VARCHAR(255)", "NOT NULL", "BCrypt encrypted password hash"),
        ("role", "VARCHAR(20)", "NOT NULL", "STUDENT, ADMIN")
    ]
    for i, (cn, dt, cs, d_desc) in enumerate(u_cols, 1):
        c0, c1, c2, c3 = tbl_u.cell(i, 0), tbl_u.cell(i, 1), tbl_u.cell(i, 2), tbl_u.cell(i, 3)
        c0.width, c1.width, c2.width, c3.width = Inches(1.2), Inches(1.1), Inches(1.3), Inches(2.17)
        set_cell_properties(c0, bold=True, text=cn)
        set_cell_properties(c1, text=dt)
        set_cell_properties(c2, text=cs)
        set_cell_properties(c3, text=d_desc)

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 5: IMPLEMENTATION & CODE STRUCTURE
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 5: IMPLEMENTATION & CODE STRUCTURE")
    add_main_heading("5.1 User Interface Screenshots & Visual Walkthrough")
    add_sub_heading("5.1.1 CareerForge Core Module Screenshots")

    screenshots = [
        ("Figure 5.1", "SCREENSHOT 1: STUDENT LOGIN & ONBOARDING", "Insert screenshot of Login and Registration interface with role selection.", "Student Authentication and Onboarding Interface"),
        ("Figure 5.2", "SCREENSHOT 2: STUDENT DASHBOARD & ROADMAP PROGRESS", "Insert screenshot of Student Dashboard displaying overall and per-roadmap completion rates.", "Student Dashboard & Roadmap Progress Tracking View"),
        ("Figure 5.3", "SCREENSHOT 3: INTERACTIVE ROADMAP & JOURNEY VIEW", "Insert screenshot of Interactive Placement Roadmap with hierarchical sections and question checkboxes.", "Interactive Placement Roadmap & Section Journey View"),
        ("Figure 5.4", "SCREENSHOT 4: TOPIC-LEVEL PRACTICE SHEETS", "Insert screenshot of Curated Practice Sheets (DSA, Web Dev, AI/ML) with progress bars.", "Topic-Level Practice Sheets (DSA / Web Dev / AI-ML)"),
        ("Figure 5.5", "SCREENSHOT 5: CENTRALIZED RESOURCE REPOSITORY", "Insert screenshot of Categorized Subject Folders with curated links and guides.", "Centralized Resource Library & Folder Navigation View"),
        ("Figure 5.6", "SCREENSHOT 6: REAL-TIME WEBSOCKET CHAT CHANNELS", "Insert screenshot of Year-wise Public Chat Rooms and 1-on-1 Direct Messaging.", "Real-Time Year-Wise & 1-on-1 Student Chat Channels (WebSocket)"),
        ("Figure 5.7", "SCREENSHOT 7: ADMIN MANAGEMENT PORTAL", "Insert screenshot of Admin Dashboard for managing roadmaps, resources, and chat moderation.", "Administrator Management Portal & Platform Overview")
    ]

    for f_no, s_title, s_inst, s_cap in screenshots:
        add_placeholder_box(s_title, s_inst, height_in_inches=2.0)
        add_figure_caption(f"{f_no}: {s_cap}")

    add_sub_heading("5.1.2 Kernel Competitive Coding Arena Screenshots")
    kernel_screenshots = [
        ("Figure 5.8", "SCREENSHOT 8: KERNEL CONTEST PROBLEM ARENA", "Insert screenshot of Kernel Problem Solving Arena with Monaco Code Editor and Sample Test Console.", "Kernel Contest Problem Arena with Monaco Code Editor"),
        ("Figure 5.9", "SCREENSHOT 9: KERNEL LIVE CONTEST LEADERBOARD", "Insert screenshot of Real-Time Contest Rankings based on Problems Solved and Penalty Timing.", "Kernel Live Contest Leaderboard & Scoring View")
    ]

    for f_no, s_title, s_inst, s_cap in kernel_screenshots:
        add_placeholder_box(s_title, s_inst, height_in_inches=2.0)
        add_figure_caption(f"{f_no}: {s_cap}")

    add_main_heading("5.2 Key Source Code Implementation Modules")

    add_sub_heading("5.2.1 WebSocket STOMP Message Broker Configuration (Akash)")
    code_ws = """@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // In-memory message broker prefixes
        config.enableSimpleBroker("/topic", "/queue");
        // Application destination prefix for message handling methods
        config.setApplicationDestinationPrefixes("/app");
        // Prefix used for user-specific direct messaging
        config.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket handshake endpoint with SockJS fallback
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}"""
    add_code_block(code_ws)

    add_sub_heading("5.2.2 Roadmap Progress Calculation & Service Logic (Aman)")
    code_roadmap = """@Service
@RequiredArgsConstructor
public class RoadmapService {

    private final RoadmapRepository roadmapRepository;
    private final UserQuestionProgressRepository progressRepository;

    @Transactional(readOnly = true)
    public RoadmapProgressDto calculateProgress(UUID roadmapId, UUID userId) {
        long totalQuestions = roadmapRepository.countQuestionsByRoadmapId(roadmapId);
        long completedQuestions = progressRepository.countCompletedByRoadmapAndUser(roadmapId, userId);
        
        double percentage = totalQuestions > 0 ? ((double) completedQuestions / totalQuestions) * 100.0 : 0.0;
        return new RoadmapProgressDto(roadmapId, totalQuestions, completedQuestions, Math.round(percentage * 100.0) / 100.0);
    }
}"""
    add_code_block(code_roadmap)

    add_sub_heading("5.2.3 Kernel Monaco & CodeBox Execution Pipeline (Kushagra)")
    code_kernel = """// Kernel code execution service invoking self-hosted CodeBox server
export async function executeCode(sourceCode: string, languageId: number, testCases: TestCase[]) {
  const payload = {
    source_code: sourceCode,
    language_id: languageId,
    test_cases: testCases.map(tc => ({ input: tc.input, expected_output: tc.expectedOutput }))
  };

  const response = await fetch(`${process.env.CODEBOX_URL}/submissions/batch`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload)
  });

  const results = await response.json();
  const passedCount = results.filter((r: any) => r.status.id === 3).length; // 3 = Accepted
  return { passedCount, totalCount: testCases.length, results };
}"""
    add_code_block(code_kernel)

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 6: TESTING & QUALITY ASSURANCE
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 6: TESTING & QUALITY ASSURANCE")
    add_main_heading("6.1 Testing Methodologies & Strategy")
    add_body_paragraph("Testing was conducted across unit, integration, and end-to-end levels to ensure high reliability across Authentication, Roadmaps, WebSocket Chat, and Kernel Code Execution.")

    add_main_heading("6.2 Test Case Specifications & Execution Matrices")
    add_table_caption("Table 6.1: Unit & Integration Test Suites (Authentication & Roadmaps)")
    tbl_tc = doc.add_table(rows=6, cols=5)
    tbl_tc.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_tc.autofit = False
    set_cell_properties(tbl_tc.cell(0, 0), bold=True, text="Test ID")
    set_cell_properties(tbl_tc.cell(0, 1), bold=True, text="Test Scenario")
    set_cell_properties(tbl_tc.cell(0, 2), bold=True, text="Input / Precondition")
    set_cell_properties(tbl_tc.cell(0, 3), bold=True, text="Expected Output")
    set_cell_properties(tbl_tc.cell(0, 4), bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text="Status")
    tbl_tc.cell(0, 0).width = Inches(0.8)
    tbl_tc.cell(0, 1).width = Inches(1.4)
    tbl_tc.cell(0, 2).width = Inches(1.4)
    tbl_tc.cell(0, 3).width = Inches(1.5)
    tbl_tc.cell(0, 4).width = Inches(0.67)

    tc_data = [
        ("TC-01", "User Registration Valid", "Name, college email, password", "HTTP 201 Created, User saved", "PASSED"),
        ("TC-02", "User Login Valid Credentials", "Correct email & password", "HTTP 200 OK with signed JWT token", "PASSED"),
        ("TC-03", "Access Protected Roadmap", "Request with valid Bearer JWT", "HTTP 200 OK with Roadmap DTO", "PASSED"),
        ("TC-04", "Toggle Question Checkbox", "User ID and Question ID marked solved", "Progress stored, checkbox checked", "PASSED"),
        ("TC-05", "Calculate Progress %", "15 of 30 questions solved", "Returns exactly 50.0% completion", "PASSED")
    ]
    for i, (tid, scn, inp, exp, st) in enumerate(tc_data, 1):
        c0, c1, c2, c3, c4 = tbl_tc.cell(i, 0), tbl_tc.cell(i, 1), tbl_tc.cell(i, 2), tbl_tc.cell(i, 3), tbl_tc.cell(i, 4)
        c0.width, c1.width, c2.width, c3.width, c4.width = Inches(0.8), Inches(1.4), Inches(1.4), Inches(1.5), Inches(0.67)
        set_cell_properties(c0, bold=True, text=tid)
        set_cell_properties(c1, text=scn)
        set_cell_properties(c2, text=inp)
        set_cell_properties(c3, text=exp)
        set_cell_properties(c4, bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text=st)

    add_table_caption("Table 6.2: WebSocket STOMP Messaging & Kernel Judge Tests")
    tbl_tc2 = doc.add_table(rows=6, cols=5)
    tbl_tc2.alignment = WD_TABLE_ALIGNMENT.CENTER
    tbl_tc2.autofit = False
    set_cell_properties(tbl_tc2.cell(0, 0), bold=True, text="Test ID")
    set_cell_properties(tbl_tc2.cell(0, 1), bold=True, text="Test Scenario")
    set_cell_properties(tbl_tc2.cell(0, 2), bold=True, text="Input / Precondition")
    set_cell_properties(tbl_tc2.cell(0, 3), bold=True, text="Expected Output")
    set_cell_properties(tbl_tc2.cell(0, 4), bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text="Status")
    tbl_tc2.cell(0, 0).width = Inches(0.8)
    tbl_tc2.cell(0, 1).width = Inches(1.4)
    tbl_tc2.cell(0, 2).width = Inches(1.4)
    tbl_tc2.cell(0, 3).width = Inches(1.5)
    tbl_tc2.cell(0, 4).width = Inches(0.67)

    tc2_data = [
        ("TC-06", "WebSocket STOMP Handshake", "Valid JWT in CONNECT header", "Connection established, ACK received", "PASSED"),
        ("TC-07", "Year-Wise Room Broadcast", "Message sent to /app/chat.send", "Broadcast to subscribers in < 50ms", "PASSED"),
        ("TC-08", "Kernel Monaco Code Run", "Python solution for Two Sum", "CodeBox returns sample test Passed", "PASSED"),
        ("TC-09", "Kernel CodeBox Submission", "Complete test suite execution", "Verdict: Accepted (AC), score updated", "PASSED"),
        ("TC-10", "Live Leaderboard Update", "Student passes all problems", "Student placed at Rank 1 on leaderboard", "PASSED")
    ]
    for i, (tid, scn, inp, exp, st) in enumerate(tc2_data, 1):
        c0, c1, c2, c3, c4 = tbl_tc2.cell(i, 0), tbl_tc2.cell(i, 1), tbl_tc2.cell(i, 2), tbl_tc2.cell(i, 3), tbl_tc2.cell(i, 4)
        c0.width, c1.width, c2.width, c3.width, c4.width = Inches(0.8), Inches(1.4), Inches(1.4), Inches(1.5), Inches(0.67)
        set_cell_properties(c0, bold=True, text=tid)
        set_cell_properties(c1, text=scn)
        set_cell_properties(c2, text=inp)
        set_cell_properties(c3, text=exp)
        set_cell_properties(c4, bold=True, align=WD_ALIGN_PARAGRAPH.CENTER, text=st)

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 7: SUMMARY & CONCLUSION
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 7: SUMMARY & CONCLUSION")
    add_main_heading("7.1 Summary of Work Accomplished")
    add_body_paragraph("During the 7th semester summer training period, CareerForge was successfully architected, implemented, and verified across its core modules:")
    add_bullet_item("", "Full implementation of a high-performance Spring Boot 3 REST backend with JWT authentication and PostgreSQL storage.")
    add_bullet_item("", "Creation of semester-aware technology roadmaps and practice sheets with dynamic progress calculation (Aman).")
    add_bullet_item("", "Integration of low-latency WebSocket (STOMP) group and direct chat infrastructure (Akash).")
    add_bullet_item("", "Development of the Kernel contest platform with Monaco code editor, sandboxed CodeBox execution, and live leaderboards (Kushagra).")
    add_bullet_item("", "Design and implementation of a responsive, modern frontend architecture across the platform (Vivek).")

    add_main_heading("7.2 Key Academic & Technical Learnings")
    add_bullet_item("Full-Stack Micro-Modular Design: ", "Structuring decoupled services with clean separation between REST, WebSockets, and Next.js.")
    add_bullet_item("Real-Time Asynchronous Systems: ", "Mastering STOMP message brokers, topic destinations, and duplex socket connections.")
    add_bullet_item("Sandboxed Code Execution: ", "Understanding containerized process limits, CPU/memory sandboxing, and Judge0 protocols.")
    add_bullet_item("Team Leadership & Agile Engineering: ", "Effective pair programming, sprint planning, and component integration.")

    add_main_heading("7.3 Conclusion")
    add_body_paragraph("CareerForge provides an impactful, unified platform that streamlines placement preparation for engineering colleges. By combining structured roadmaps, centralized resources, real-time peer discussion, and competitive coding practice into a single platform, it empowers students to prepare with structure, consistency, and confidence.")

    doc.add_page_break()

    # -------------------------------------------------------------
    # CHAPTER 8: LIMITATIONS & FUTURE SCOPE
    # -------------------------------------------------------------
    add_chapter_heading("CHAPTER 8: LIMITATIONS & FUTURE SCOPE")
    add_main_heading("8.1 Limitations of Current System")
    add_bullet_item("Language Support in Judge: ", "The initial release of Kernel supports Python, C++, Java, C, and JavaScript, with languages like Go and Rust slated for future updates.")
    add_bullet_item("Manual Resume Evaluation: ", "Roadmaps are currently selected manually without automated AI resume scanning.")

    add_main_heading("8.2 Future Scope & Proposed Enhancements")
    add_bullet_item("AI Placement Assistant: ", "Integrating Large Language Models (LLMs) to provide automated coding hints and mock interview simulations.")
    add_bullet_item("Automated ATS Resume Analyzer: ", "Scanning resumes to automatically recommend missing topics on the student roadmap.")
    add_bullet_item("Mobile Client: ", "Developing a React Native mobile application for on-the-go chat and roadmap progress tracking.")

    doc.add_page_break()

    # -------------------------------------------------------------
    # BIBLIOGRAPHY & REFERENCES (OFFICIAL DOCUMENTATION)
    # -------------------------------------------------------------
    add_chapter_heading("BIBLIOGRAPHY & REFERENCES")
    refs = [
        "[1] Spring Framework & Spring Boot Official Documentation, VMware Tanzu. Available: https://docs.spring.io/spring-boot/docs/current/reference/html/",
        "[2] Spring Security Reference Documentation & JWT Architecture Guide, Spring.io. Available: https://docs.spring.io/spring-security/reference/",
        "[3] Spring WebSocket and STOMP Protocol Messaging Reference Guide, Spring.io. Available: https://docs.spring.io/spring-framework/reference/web/websocket.html",
        "[4] PostgreSQL 16 Official Database Documentation, PostgreSQL Global Development Group. Available: https://www.postgresql.org/docs/16/",
        "[5] React.js Official Documentation & Modern Hook Patterns, Meta Open Source. Available: https://react.dev/",
        "[6] TypeScript Handbook & Language Specifications, Microsoft Corporation. Available: https://www.typescriptlang.org/docs/handbook/",
        "[7] Vite: Next Generation Frontend Tooling Documentation, Evan You & Vite Contributors. Available: https://vitejs.dev/guide/",
        "[8] Tailwind CSS Utility-First CSS Framework Documentation, Tailwind Labs. Available: https://tailwindcss.com/docs",
        "[9] Next.js 16 Documentation and Monaco Code Editor API Guide, Vercel & Microsoft. Available: https://nextjs.org/docs and https://microsoft.github.io/monaco-editor/",
        "[10] Judge0 Open-Source Code Execution Engine API Documentation, Herman Zvonimir Došilović. Available: https://judge0.com/docs"
    ]
    for r_text in refs:
        p = doc.add_paragraph()
        p.alignment = WD_ALIGN_PARAGRAPH.JUSTIFY
        p.paragraph_format.line_spacing = 1.15
        p.paragraph_format.space_after = Pt(6)
        r = p.add_run(r_text)
        r.font.name = 'Times New Roman'
        r.font.size = Pt(11)

    doc.add_page_break()

    # -------------------------------------------------------------
    # APPENDICES
    # -------------------------------------------------------------
    add_chapter_heading("APPENDICES")
    add_main_heading("Appendix A: Installation & Local Setup Guide")
    add_sub_heading("1. Prerequisites")
    add_bullet_item("", "Java Development Kit (JDK 21 or later)")
    add_bullet_item("", "Node.js (v18.x or v20.x) and npm")
    add_bullet_item("", "PostgreSQL Database Server (v15+)")
    add_bullet_item("", "Self-Hosted CodeBox / Judge0 Execution Instance")

    add_sub_heading("2. Backend Setup (Spring Boot)")
    code_setup_be = """cd careerforge
export DB_URL=jdbc:postgresql://localhost:5432/careerforge
export DB_USERNAME=postgres
export DB_PASSWORD=your_secure_password
export JWT_SECRET=your_base64_encoded_256bit_secret_key
./mvnw clean spring-boot:run"""
    add_code_block(code_setup_be)

    add_sub_heading("3. Frontend Setup (React & Vite)")
    code_setup_fe = """cd ../careerforge-frontend
npm install
npm run dev"""
    add_code_block(code_setup_fe)

    add_sub_heading("4. Kernel Contest Platform Setup (Next.js)")
    code_setup_kernel = """cd ../kernel
export CODEBOX_URL=http://localhost:3000
npm install
npm run dev"""
    add_code_block(code_setup_kernel)

    doc.save(output_path)
    print(f"Successfully generated scoped report at: {output_path}")

    import shutil
    try:
        shutil.copyfile(output_path, main_output_path)
        print(f"Copied to main output path: {main_output_path}")
    except Exception as e:
        print(f"Note: Could not overwrite {main_output_path} directly: {e}")

    try:
        shutil.copyfile(output_path, artifact_path)
        print(f"Copied to artifact path: {artifact_path}")
    except Exception as e:
        print(f"Note: Could not copy to artifact path: {e}")

    if os.path.exists('temp_image1.jpeg'):
        os.remove('temp_image1.jpeg')

if __name__ == "__main__":
    generate_scoped_report()
